package pl.braintelligence.todolist.task

import org.springframework.core.ParameterizedTypeReference
import pl.braintelligence.todolist.BaseIntegrationTest
import pl.braintelligence.todolist.application.dto.NewTaskDto
import pl.braintelligence.todolist.application.dto.NewTasksListDto
import pl.braintelligence.todolist.application.dto.ExistingTasksListDto
import pl.braintelligence.todolist.application.dto.TasksListDto

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

class TasksListEndpointTest extends BaseIntegrationTest {

    def listName1, listName2
    def newTasksListDto1, newTasksListDto2

    def setup() {
        listName1 = "Serials to watch"
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
        def response = get("/lists", new ParameterizedTypeReference<List<ExistingTasksListDto>>() {})

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

    def "Should create TasksList and add task to it and return list with tasks"() {
        given:
        post("/lists", newTasksListDto1)
        def task1 = "WATCH Rick and Morty!"
        def task2 = "Watch Game of Thrones"
        def newTaskDto1 = new NewTaskDto(text: task1)
        def newTaskDto2 = new NewTaskDto(text: task2)

        when:
        def response = post("/lists/$listName1/tasks", newTaskDto1)
        response = post("/lists/$listName1/tasks", newTaskDto2)

        then:
        response.statusCode.is2xxSuccessful()

        when:
        response = get("/lists/$listName1", TasksListDto.class)

        then:
        response.statusCode.is2xxSuccessful()
        response.body.name == listName1
        response.body.tasks.size() == 2
        response.body.tasks[0].text == task1
        response.body.tasks[1].text == task2

    }

}
