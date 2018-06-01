package pl.braintelligence.todolist.task

import org.springframework.core.ParameterizedTypeReference
import pl.braintelligence.todolist.BaseIntegrationTest
import pl.braintelligence.todolist.application.dto.AllTasksDto
import pl.braintelligence.todolist.application.dto.NewTaskDto

import static org.springframework.http.HttpMethod.GET
import static org.springframework.http.HttpMethod.POST

class TaskEndpointTest extends BaseIntegrationTest {

    def task_text
    def newTaskDto
    def entity

    def setup() {
        task_text = "MUST watch Rick and Morty on the weekend"
        newTaskDto = new NewTaskDto(text: task_text)
        entity = prepareHttpEntity(newTaskDto)

    }

    def "Should create new task and return it"() {
        given:
        def entity = prepareHttpEntity(newTaskDto)

        when:
        def response = restTemplate.exchange("/tasks", POST, entity, Void)


        then:
        response.statusCode.is2xxSuccessful()

        when:
        response = restTemplate.exchange("/tasks", GET, entity, new ParameterizedTypeReference<List<AllTasksDto>>() {
        })

        then:
        response.statusCode.is2xxSuccessful()

        with(response.body[0]) {
            text == task_text
        }
    }

    def "Should create new task 2and return it"() {
        given:
        def entity = prepareHttpEntity(newTaskDto)

        when:
        def response = restTemplate.exchange("/tasks", POST, entity, Void)

        then:
        response.statusCode.is2xxSuccessful()

        when:
        response = restTemplate.exchange("/tasks", GET, entity, new ParameterizedTypeReference<List<AllTasksDto>>() {
        })

        then:
        response.statusCode.is2xxSuccessful()

        with(response.body[0]) {
            text == task_text
        }
    }

    def "Should create 20 new tasks"() {
        given:
        (1..20).each {
            def tempNewTaskDto = new NewTaskDto(text: task_text + it)
            def tempEntity = prepareHttpEntity(tempNewTaskDto)
            restTemplate.exchange("/tasks", POST, tempEntity, Object.class)
        }

        when:
        def response = restTemplate.getForEntity("/tasks", Object)

        then:
        response.statusCode.is2xxSuccessful()
        response.body.size() == 20
    }

}
