package pl.braintelligence.todolist.taskslist

import pl.braintelligence.todolist.application.dto.NewTaskDto
import pl.braintelligence.todolist.application.dto.NewTasksListDto

trait SampleData {

    NewTasksListDto blog_list = createTasksList("Blog posts")
    NewTasksListDto serials_to_watch_list = createTasksList("Serials to watch")
    NewTasksListDto empty_list_name = createTasksList("")

    NewTaskDto newTaskDto1 = createTask("Watch Rick and Morty!")
    NewTaskDto newTaskDto2 = createTask("Watch Game of Thrones!")

    static private NewTasksListDto createTasksList(String name) {
        NewTasksListDto newTasksListDto = new NewTasksListDto()
        newTasksListDto.setName(name)
        return newTasksListDto
    }

    static private NewTaskDto createTask(String task) {
        NewTaskDto newTaskDto = new NewTaskDto()
        newTaskDto.setText(task)
        return newTaskDto
    }

}
