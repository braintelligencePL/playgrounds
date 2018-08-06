class PostPublisher {

    static final Map SAMPLE_NEW_BLOG_POST = [
            "id"         : "id-1234",
            "title"      : "Spock Tricks",
            "photo"      : "https://braintelligence.pl/...",
            "content"    : "Lorem ipsum dolor sit....",
            "publishDate": "2018-08-08T00:42:42Z",
            "category"   : ["unit-tests", "integration-tests"],
            "tags"       : ["tdd", "bdd", "tests"],

    ]

    static NewBlogPostDto sampleNewBlogPost(Map<String, Object> properties = [:]) {
        properties = SAMPLE_NEW_BLOG_POST + properties
        return new NewBlogPostDto(
                properties.id,
                properties.title,
                properties.photo,
                properties.content,
                properties.publishDate,
                properties.category,
                properties.tags
        )
    }
}
