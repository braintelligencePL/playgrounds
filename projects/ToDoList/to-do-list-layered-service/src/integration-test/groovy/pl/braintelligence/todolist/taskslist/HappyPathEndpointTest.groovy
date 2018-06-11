package pl.braintelligence.todolist.taskslist

import org.springframework.core.ParameterizedTypeReference
import pl.braintelligence.todolist.BaseSetupIntegrationTest
import pl.braintelligence.todolist.application.dto.ExistingTodoListsNamesDto
import pl.braintelligence.todolist.application.dto.TodoListDto

class HappyPathEndpointTest extends BaseSetupIntegrationTest implements SampleData {

    def "Should create 2 new lists AND return all list names"() {
        given:
        def tasksList = [blog_list, serials_to_watch_list]

        tasksList.each {
            post("/lists", it)
        }

        when:
        def response = get("/lists", new ParameterizedTypeReference<List<ExistingTodoListsNamesDto>>() {})

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
        response = get("/lists/$blog_list.name", TodoListDto.class)

        then:
        response.statusCode.is2xxSuccessful()
        response.body.name == blog_list.name
        response.body.tasks.size() == 2
        response.body.tasks[0].text == newTaskDto1.text
        response.body.tasks[1].text == newTaskDto2.text

    }

}
