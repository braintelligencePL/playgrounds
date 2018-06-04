package pl.braintelligence.todolist.task

import org.springframework.core.ParameterizedTypeReference
import pl.braintelligence.todolist.BaseIntegrationTest
import pl.braintelligence.todolist.application.dto.NewTaskDto
import pl.braintelligence.todolist.application.dto.NewTasksListDto
import pl.braintelligence.todolist.application.dto.TasksListDto

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

class TasksListEndpointTest extends BaseIntegrationTest {

    def listName1, listName2
    def newTasksListDto1, newTasksListDto2;

    def setup() {
        listName1 = "1"
        listName2 = "Grocery"
        newTasksListDto1 = new NewTasksListDto(name: listName1)
        newTasksListDto2 = new NewTasksListDto(name: listName2)

    }

    def "Should create 2 new TasksList and return it"() {
        given:
        def tasksList = [newTasksListDto1, newTasksListDto2]

        tasksList.each {
            post("/lists", it)
        }

        when:
        def response = get("/lists", new ParameterizedTypeReference<List<TasksListDto>>() {})

        then:
        response.statusCode.is2xxSuccessful()
        response.body.size() == 2
        response.getBody()[0].name == listName1
        response.getBody()[1].name == listName2
    }

    def "Should not create TasksList with the same name"() {

        when:
        def response = post("/lists", newTasksListDto1)
        response = post("/lists", newTasksListDto1)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY

    }

    def "Should create TasksList and add task to it and return list with task"() {
        given:
        post("/lists", newTasksListDto1)
        def newTaskDto = new NewTaskDto(text: "WATCH Rick and Morty!")

        when:
        def response = post("/lists/$listName1/tasks", newTaskDto)

        then:
        response.statusCode.is2xxSuccessful()

    }

}
