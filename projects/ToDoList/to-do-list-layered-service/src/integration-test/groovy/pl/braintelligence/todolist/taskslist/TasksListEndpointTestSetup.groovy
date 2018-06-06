package pl.braintelligence.todolist.taskslist

import org.springframework.core.ParameterizedTypeReference
import pl.braintelligence.todolist.BaseSetupIntegrationTest
import pl.braintelligence.todolist.application.dto.ExistingTasksListDto
import pl.braintelligence.todolist.application.dto.TasksListDto

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

class TasksListEndpointTestSetup extends BaseSetupIntegrationTest implements SampleData {

    def "Should create 2 new TasksList AND return it"() {
        given:
        def tasksList = [blog_list, serials_to_watch_list]

        tasksList.each {
            post("/lists", it)
        }

        when:
        def response = get("/lists", new ParameterizedTypeReference<List<ExistingTasksListDto>>() {})

        then:
        response.statusCode.is2xxSuccessful()
        response.body.size() == 2
        response.getBody()[0].name == blog_list.name
        response.getBody()[1].name == serials_to_watch_list.name
    }

    def "Should create TasksList and add task to it and return list with tasks"() {
        given:
        post("/lists", blog_list)

        when:
        def response = post("/lists/$blog_list.name/tasks", newTaskDto1)
        response = post("/lists/$blog_list.name/tasks", newTaskDto2)

        then:
        response.statusCode.is2xxSuccessful()

        when:
        response = get("/lists/$blog_list.name", TasksListDto.class)

        then:
        response.statusCode.is2xxSuccessful()
        response.body.name == blog_list.name
        response.body.tasks.size() == 2
        response.body.tasks[0].text == newTaskDto1.text
        response.body.tasks[1].text == newTaskDto2.text

    }

    def "Should not create TasksList with the same name"() {

        when:
        def response = post("/lists", blog_list)
        response = post("/lists", blog_list)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY

    }

    def "Should not create list without name"() {

        when:
        def response = post("/lists", emptyTasksListDto)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.code == 'EMPTY_LIST_NAME'
    }

    def "Should not add task to non-existent-list"() {
        when:
        def response = get("/lists/$blog_list.name", TasksListDto.class)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.code == 'NON_EXISTENT_TASKS_LIST'
    }



}
