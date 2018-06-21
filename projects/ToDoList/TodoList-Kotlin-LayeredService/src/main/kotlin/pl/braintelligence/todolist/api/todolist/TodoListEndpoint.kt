package pl.braintelligence.todolist.api.todolist

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pl.braintelligence.todolist.application.TodoListService
import java.lang.invoke.MethodHandles

@RestController
@RequestMapping(value = ["/lists"])
class TodoListEndpoint constructor(
        val todoListService: TodoListService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewTodoList(newTodoListDto: NewTodoListDto) {
        logger.info("list action - create new TodoList", newTodoListDto)
        todoListService.createNewTodoList(newTodoListDto)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }
}
