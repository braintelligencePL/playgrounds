package pl.braintelligence.todolist.taskslist

import pl.braintelligence.todolist.application.dto.NewTaskDto
import pl.braintelligence.todolist.application.dto.NewTodoListDto

trait SampleData {

    NewTodoListDto blog_list = createTasksList("Blog posts")
    NewTodoListDto serials_to_watch_list = createTasksList("Serials to watch")
    NewTodoListDto empty_list_name = createTasksList("")

    NewTaskDto newTaskDto1 = createTask("Watch Rick and Morty!")
    NewTaskDto newTaskDto2 = createTask("New Season of Game of Thrones!")

    static private NewTodoListDto createTasksList(String name) {
        NewTodoListDto newTasksListDto = new NewTodoListDto()
        newTasksListDto.setName(name)
        return newTasksListDto
    }

    static private NewTaskDto createTask(String task) {
        NewTaskDto newTaskDto = new NewTaskDto()
        newTaskDto.setText(task)
        return newTaskDto
    }

}
