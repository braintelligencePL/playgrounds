package pl.braintelligence.todolist

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.*
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class BaseIntegrationTest extends Specification {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(12346)

    @Autowired
    TestRestTemplate restTemplate

    @Value('${local.server.port}')
    protected int port

    protected String localUrl(String endpoint) {
        return "http://localhost:$port$endpoint"
    }

    protected static <T> HttpEntity<T> prepareHttpEntity(T data, Map<String, List<String>> additionalHeaders = [:]) {
        def headers = new HttpHeaders()

        headers.putAll(additionalHeaders)
        return new HttpEntity<T>(data, headers)
    }
}
