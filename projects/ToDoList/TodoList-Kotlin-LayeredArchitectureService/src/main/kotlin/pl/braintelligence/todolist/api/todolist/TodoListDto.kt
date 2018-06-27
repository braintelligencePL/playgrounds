package pl.braintelligence.todolist.api.todolist

import pl.braintelligence.todolist.domain.todolist.TodoList

data class NewTodoListDto(
        val name: String
) {
    companion object {
        fun toTodoList(newTodoListDto: NewTodoListDto): TodoList =
                TodoList(
                        newTodoListDto.name
                )
    }
}