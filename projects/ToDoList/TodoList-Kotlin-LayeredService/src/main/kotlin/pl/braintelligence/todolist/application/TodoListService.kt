package pl.braintelligence.todolist.application

import org.springframework.stereotype.Service
import pl.braintelligence.todolist.api.todolist.NewTodoListDto
import pl.braintelligence.todolist.domain.todolist.TodoListRepository

@Service
class TodoListService constructor(
    val todoListRepository: TodoListRepository
) {
    fun createNewTodoList(newTodoListDto: NewTodoListDto) {

        todoListRepository.save(NewTodoListDto.toTodoList(newTodoListDto))
    }
}
