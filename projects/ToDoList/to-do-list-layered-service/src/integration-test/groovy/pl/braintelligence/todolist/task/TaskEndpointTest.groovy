package pl.braintelligence.todolist.task

import pl.braintelligence.todolist.BaseIntegrationTest
import pl.braintelligence.todolist.application.dto.NewTask

import static org.springframework.http.HttpMethod.POST

class TaskEndpointTest extends BaseIntegrationTest {

    def "Should create new task"() {
        given:
        def newTask = new NewTask(text: "Watch Rick and Morty")
        def entity = prepareHttpEntity(newTask)

        when:
        def response = restTemplate.exchange(localUrl("/tasks"), POST, entity, Void)

        then:
        response.statusCode.is2xxSuccessful()
    }

}
