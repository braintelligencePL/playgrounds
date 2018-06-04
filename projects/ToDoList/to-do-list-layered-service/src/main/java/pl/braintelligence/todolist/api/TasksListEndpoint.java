package pl.braintelligence.todolist.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.braintelligence.todolist.application.TasksListService;
import pl.braintelligence.todolist.application.dto.NewTaskDto;
import pl.braintelligence.todolist.application.dto.NewTasksListDto;
import pl.braintelligence.todolist.application.dto.TasksListDto;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/lists")
public class TasksListEndpoint {

    private final TasksListService tasksListService;

    public TasksListEndpoint(TasksListService tasksListService) {
        this.tasksListService = tasksListService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createNewTasksList(@RequestBody NewTasksListDto newTasksListDto) {
        tasksListService.createNewTasksList(newTasksListDto);
    }

    @ResponseStatus(OK)
    @ResponseBody
    @GetMapping(produces = "application/json")
    public List<TasksListDto> getTasksLists() {
        return tasksListService.getTasksLists();
    }

    @ResponseStatus(CREATED)
    @PostMapping("/{listName}/tasks")
    public void addTaskToTasksList(@PathVariable String listName, @RequestBody NewTaskDto newTaskDto) {
        tasksListService.addTaskToTasksList(listName, newTaskDto);
    }

}
