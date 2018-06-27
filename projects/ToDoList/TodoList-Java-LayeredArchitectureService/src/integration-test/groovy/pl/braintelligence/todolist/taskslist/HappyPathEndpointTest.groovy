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


    def "Should create TodoList and add tasks to it and return list with tasks"() {
        given:
        def response = post("/lists", serials_to_watch_list )

        when:
        response = get("/lists/$serials_to_watch_list.name", TodoListDto.class)

        then:
        response.body.tasks.size() == 0


        when:
        post("/lists/$serials_to_watch_list.name/tasks", newTaskDto1)
        response = get("/lists/$serials_to_watch_list.name", TodoListDto.class)

        then:
        response.statusCode.is2xxSuccessful()
        response.body.name == serials_to_watch_list.name
        response.body.tasks.size() == 1
        response.body.tasks[0].text == newTaskDto1.text


        when:
        post("/lists/$serials_to_watch_list.name/tasks", newTaskDto2)
        response = get("/lists/$serials_to_watch_list.name", TodoListDto.class)

        then:
        response.body.tasks.size() == 2
    }

}
