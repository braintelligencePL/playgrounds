class SampleNewPostDto {

    static final Map SAMPLE_NEW_BLOG_POST = [
            "title"      : "Spock Tricks",
            "photo"      : "https://braintelligence.pl/...",
            "content"    : "Lorem ipsum dolor sit....",
            "publishDate": "2018-08-08T00:42:42Z",
            "category"   : ["unit-tests", "integration-tests"],
            "tags"       : ["tdd", "bdd", "tests"]

    ]

    static NewBlogPostDto sampleNewPost(Map<String, Object> properties = [:]) {
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

class PostPublisher extends Specification {
    
    def "Should create new blog post"() {
        given:
            NewBlogPostDto newBlogPost = sampleNewPost()
        when:
           ...
        then: 
           ...
    }
    
    def "Shouldn't create new blog post without title"() {
        given:
            NewBlogPostDto newBlogPost = sampleNewPost( title: null )
        when:
           ...
        then: 
           ...
        
    }

    
}
