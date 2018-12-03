# Run application with Docker
### Building [news-service](https://github.com/braintelligencePL/news-app) (backend)
1. Run from command line or IDE (Gradle):
`gradle clean build docker`

2. Command `gradle docker` generated `.jar` file that can be found here `build/docker/news-service-0.1.0.jar`.

3. Now build docker image `docker build -f Dockerfile -t docker-news-service.jar .`
```
Docker script on which you'll build an image:
`-f Dockerfile`

Name of your image:
`-t docker-news-service`

Dot at the end simply means build from this file.
` . `
```

4. Run `docker images` or `docker image ls` to find image that you've just build.

5. Run docker image `docker run -p 8085:8080 docker-news-service`

```

Expose that port to outside world:
`-p 8085 ` - 

Your application port:
' :8080 ' - default spring-boot port

```

6. Finally you can check our application. 
Run `localhost:8085/news/pl/technology` to see results.

# Still Having trouble? Try these.

- `gradle wrapper`
- `docker run -it openjdk java -version`
