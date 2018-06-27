package pl.braintelligence.todolist

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import static org.springframework.http.HttpMethod.GET
import static org.springframework.http.HttpMethod.PATCH
import static org.springframework.http.HttpMethod.POST
import static org.springframework.http.HttpMethod.PUT

@SpringBootTest(webEnvironment = RANDOM_PORT)
class BaseSetupIntegrationTest extends Specification {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(12346)

    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    private MongoTemplate mongo

    void setupSpec() {
        customWiremockSetup()
    }

    void setup() {
        clearMongoDb()
    }

    protected static <T> HttpEntity<T> preparePayload(T data, Map<String, List<String>> additionalHeaders = [:]) {
        def headers = new HttpHeaders()

        headers.putAll(additionalHeaders)
        return new HttpEntity<T>(data, headers)
    }

    protected <T> ResponseEntity<T> get(String uri, Class<T> responseBodyType) {
        return sendRequest(uri, GET, null, responseBodyType)
    }

    protected <T> ResponseEntity<T> get(String uri, ParameterizedTypeReference<T> responseBodyType) {
        return sendRequest(uri, GET, null, responseBodyType)
    }

    protected ResponseEntity post(String uri, Object requestBody) {
        return sendRequest(uri, POST, requestBody, Object)
    }

    protected ResponseEntity put(String uri, Object requestBody) {
        return sendRequest(uri, PUT, requestBody, Object)
    }

    protected ResponseEntity patch(String uri) {
        return sendRequest(uri, PATCH, null, Object)
    }

    protected ResponseEntity patch(String uri, Object requestBody) {
        return sendRequest(uri, PATCH, requestBody, Object)
    }

    private <T> ResponseEntity<T> sendRequest(String uri, HttpMethod method, Object requestBody, Class<T> responseBodyType) {
        def entity = new HttpEntity<>(requestBody)
        return restTemplate.exchange(uri, method, entity, responseBodyType)
    }

    private <T> ResponseEntity<T> sendRequest(String uri, HttpMethod method, Object requestBody, ParameterizedTypeReference<T> responseBodyType) {
        def entity = new HttpEntity<>(requestBody)
        return restTemplate.exchange(uri, method, entity, responseBodyType)
    }

    private static void customWiremockSetup() {
        System.setProperty('http.keepAlive', 'false')
        System.setProperty('http.maxConnections', '1')
    }

    private void clearMongoDb() {
        for (def collection : mongo.collectionNames) {
            mongo.dropCollection(collection)
        }
    }
}
