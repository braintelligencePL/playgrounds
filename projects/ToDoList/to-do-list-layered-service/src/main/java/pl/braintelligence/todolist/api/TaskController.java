package pl.braintelligence.todolist.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.braintelligence.todolist.application.TaskService;
import pl.braintelligence.todolist.application.dto.NewTask;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createTask(@RequestBody NewTask newTask) {
        taskService.createTask(newTask);
    }

}
