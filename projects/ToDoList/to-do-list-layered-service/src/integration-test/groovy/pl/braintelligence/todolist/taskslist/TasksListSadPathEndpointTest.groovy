package pl.braintelligence.todolist.taskslist

import pl.braintelligence.todolist.BaseSetupIntegrationTest

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

class TasksListSadPathEndpointTest extends BaseSetupIntegrationTest implements SampleData {

    def "Should not create TasksList with the same name"() {

        when:
        def response = post("/lists", blog_list)
        response = post("/lists", blog_list)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY

    }

    def "Should not create list without name"() {

        when:
        def response = post("/lists", empty_list_name)

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.code == 'EMPTY_LIST_NAME'
    }

    def "Should not add task to non-existent-list"() {
        given:
        def nonExistentTasksList = "non-existent-tasks-list"

        when:
        def response = post("/lists/$nonExistentTasksList/tasks", newTaskDto1)

        then:
        response.statusCode.is4xxClientError()
        response.body.code == 'NON_EXISTENT_TASKS_LIST'
    }

}
