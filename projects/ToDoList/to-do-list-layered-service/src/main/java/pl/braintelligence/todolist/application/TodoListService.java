package pl.braintelligence.todolist.application;

import org.springframework.stereotype.Service;
import pl.braintelligence.todolist.application.dto.NewTaskDto;
import pl.braintelligence.todolist.application.dto.NewTodoListDto;
import pl.braintelligence.todolist.application.dto.ExistingTodoListsNamesDto;
import pl.braintelligence.todolist.application.dto.TodoListDto;
import pl.braintelligence.todolist.domain.taskslist.TodoList;
import pl.braintelligence.todolist.domain.taskslist.TodoListRepository;

import java.util.List;

import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToTask;
import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToTasksList;
import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToExistingTasksListDto;
import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToTasksListDto;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.EMPTY_LIST;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.LIST_ALREADY_EXISTS;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.NON_EXISTENT_LIST;
import static pl.braintelligence.todolist.domain.exceptions.PreCondition.when;


@Service
public class TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public void createNewTodoList(NewTodoListDto newTodoListDto) {

        when(todoListRepository.existsByName(newTodoListDto.getName()))
                .thenEntityAlreadyExists(LIST_ALREADY_EXISTS, "List named " + newTodoListDto.getName() + " already exists.");

        todoListRepository.save(mapToTasksList(newTodoListDto));
    }

    public List<ExistingTodoListsNamesDto> getTodoListsNames() {

        List<TodoList> todoLists = todoListRepository.findAll();

        when(todoLists.isEmpty())
                .thenMissingEntity(EMPTY_LIST, "Error getting tasks lists - none available");

        return mapToExistingTasksListDto(todoLists);
    }

    public void addTaskToTodoList(String listName, NewTaskDto newTaskDto) {

        TodoList todoList = todoListRepository.findByName(listName); // may be optimized

        when(todoList == null)
                .thenMissingEntity(NON_EXISTENT_LIST, "Error adding task to '" + listName + "' todoList - list doesn't exists");

        todoList.addTask(mapToTask(newTaskDto));

        todoListRepository.save(todoList);

    }

    public TodoListDto getTodoList(String listName) {
        TodoList todoList = todoListRepository.findByName(listName);

        return mapToTasksListDto(todoList);
    }

}
