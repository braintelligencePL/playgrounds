package pl.braintelligence.todolist.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.braintelligence.todolist.application.TodoListService;
import pl.braintelligence.todolist.application.dto.ExistingTodoListsNamesDto;
import pl.braintelligence.todolist.application.dto.NewTaskDto;
import pl.braintelligence.todolist.application.dto.NewTodoListDto;
import pl.braintelligence.todolist.application.dto.TodoListDto;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/lists")
public class TodoListEndpoint {

    private final TodoListService todoListService;

    public TodoListEndpoint(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createNewTodoList(@RequestBody NewTodoListDto newTodoListDto) {
        todoListService.createNewTodoList(newTodoListDto);
    }

    @ResponseStatus(OK)
    @ResponseBody
    @GetMapping(produces = "application/json")
    public List<ExistingTodoListsNamesDto> getTodoListsNames() {
        return todoListService.getTodoListsNames();
    }

    @ResponseStatus(CREATED)
    @PostMapping("/{listName}/tasks")
    public void addTaskToTodoList(@PathVariable String listName, @RequestBody NewTaskDto newTaskDto) {
        todoListService.addTaskToTodoList(listName, newTaskDto);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/{listName}", produces = "application/json")
    public TodoListDto getTodoList(@PathVariable String listName) {
        return todoListService.getTodoList(listName);
    }

}
