package pl.braintelligence.todolist

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class BaseIntegrationTest extends Specification {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(12346)

    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    private MongoTemplate mongo


    protected static <T> HttpEntity<T> prepareHttpEntity(T data, Map<String, List<String>> additionalHeaders = [:]) {
        def headers = new HttpHeaders()

        headers.putAll(additionalHeaders)
        return new HttpEntity<T>(data, headers)
    }

    void setupSpec() {
        customSetupWiremock()
    }

    void setup() {
        clearMongoDb()
    }

    private static void customSetupWiremock() {
        System.setProperty('http.keepAlive', 'false')
        System.setProperty('http.maxConnections', '1')
    }

    private void clearMongoDb() {
        for (def collection : mongo.collectionNames) {
            mongo.dropCollection(collection)
        }
    }
}
