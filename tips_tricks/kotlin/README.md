
## Less code in build.gradle

To remove that from build.gradle:

```kotlin
compileKotlin {
    kotlinOptions {
        freeCompilerArgs = ['-Xjsr305=strict']
        jvmTarget = '1.8'
    }
}

compileTestKotlin {
    kotlinOptions {
        freeCompilerArgs = ['-Xjsr305=strict']
        jvmTarget = '1.8'
    }
}
```

Make ApplicationStarter like that: 
```kotlin
@SpringBootApplication
class Application {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(Application::class.java, *args)
		}
	}
}
```
