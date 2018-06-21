package pl.braintelligence.todolist.domain.todolist

interface TodoListRepository {
    fun save(TodoList: TodoList)
}