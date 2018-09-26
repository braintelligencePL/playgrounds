abstract class BaseIntegrationSpec extends Specification {

    @Value('${local.server.port}')
    protected int port

    protected String localUrl(String endpoint) {
        return "http://localhost:$port$endpoint"
    }
    
}
