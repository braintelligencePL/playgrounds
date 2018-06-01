package pl.braintelligence.todolist.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.braintelligence.todolist.application.TaskService;
import pl.braintelligence.todolist.application.dto.AllTasksDto;
import pl.braintelligence.todolist.application.dto.NewTaskDto;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createTask(@RequestBody NewTaskDto newTaskDto) {
        taskService.createTask(newTaskDto);
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<AllTasksDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    //TODO: getCurrentTasks
    //TODO: getCompletedTasks

}
