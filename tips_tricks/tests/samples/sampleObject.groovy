
// -------------- STATIC WAY -------------- //
class SampleNewPost {

    static final Map SAMPLE_NEW_BLOG_POST = [
            "title"      : "Spock Tricks",
            "photo"      : "https://braintelligence.pl/...",
            "content"    : "Lorem ipsum dolor sit....",
            "publishDate": "2018-08-08T00:42:42Z",
            "category"   : ["unit-tests", "integration-tests"],
            "tags"       : ["tdd", "bdd", "tests"]

    ]

    static NewBlogPostDto sampleNewPostDto(Map<String, Object> properties = [:]) {
        properties = SAMPLE_NEW_BLOG_POST + properties
        return new NewBlogPostDto(
                properties.title,
                properties.photo,
                properties.content,
                properties.publishDate,
                properties.category,
                properties.tags
        )
    }
}

// -------------- Usage example -------------- //
class PostPublisher extends Specification {
    
    def "Should create new blog post"() {
        given:
            NewBlogPostDto newBlogPost = sampleNewPost()
        when:
        then:
            
    }
    
    def "Shouldn't create new blog post without title"() {
        given:
            NewBlogPostDto newBlogPost = sampleNewPost( title: null )
        when:
        then: 
            
    }    
}

// ------------------ OR TRAIT WAY  -------------- //
// TRAIT is kinda like inteface but it can have default implmentation and state
trait SampleNewPost {

    final Map SAMPLE_NEW_BLOG_POST = [
            "title"      : "Spock Tricks",
            "photo"      : "https://braintelligence.pl/...",
            "content"    : "Lorem ipsum dolor sit....",
            "publishDate": "2018-08-08T00:42:42Z",
            "category"   : ["unit-tests", "integration-tests"],
            "tags"       : ["tdd", "bdd", "tests"]

    ]

    NewBlogPostDto sampleNewPostDto(Map<String, Object> properties = [:]) {
        properties = SAMPLE_NEW_BLOG_POST + properties
        return new NewBlogPostDto(
                properties.title,
                properties.photo,
                properties.content,
                properties.publishDate,
                properties.category,
                properties.tags
        )
    }
}
// Works the same way
class PostPublisher extends Specification implements SampleNewPost { ... }


