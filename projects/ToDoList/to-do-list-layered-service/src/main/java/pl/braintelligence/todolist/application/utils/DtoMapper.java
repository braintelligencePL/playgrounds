package pl.braintelligence.todolist.application.utils;

import pl.braintelligence.todolist.application.dto.ExistingTodoListsNamesDto;
import pl.braintelligence.todolist.application.dto.NewTaskDto;
import pl.braintelligence.todolist.application.dto.NewTodoListDto;
import pl.braintelligence.todolist.application.dto.TodoListDto;
import pl.braintelligence.todolist.domain.taskslist.Task;
import pl.braintelligence.todolist.domain.taskslist.TodoList;
import pl.braintelligence.todolist.domain.values.Status;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DtoMapper {

    public static TodoList mapToTasksList(NewTodoListDto newTodoListDto) {
        return new TodoList(
                newTodoListDto.getName()
        );
    }

    public static List<ExistingTodoListsNamesDto> mapToExistingTasksListDto(List<TodoList> todoLists) {
        return todoLists.stream()
                .map(DtoMapper::mapToExistingTasksListDto)
                .collect(toList());
    }

    private static ExistingTodoListsNamesDto mapToExistingTasksListDto(TodoList todoList) {
        ExistingTodoListsNamesDto existingTodoListsNamesDto = new ExistingTodoListsNamesDto();
        existingTodoListsNamesDto.setName(todoList.getName());
        return existingTodoListsNamesDto;
    }

    public static Task mapToTask(NewTaskDto newTaskDto) {
        return new Task(
                newTaskDto.getText(),
                Status.PENDING
        );
    }

    public static TodoListDto mapToTasksListDto(TodoList todoList) {
        TodoListDto todoListDto = new TodoListDto();
        todoListDto.setName(todoList.getName());
        todoListDto.setTasks(
                todoList.getTasks().stream()
                        .map(DtoMapper::mapToTasksListDto)
                        .collect(toList()));
        return todoListDto;
    }

    private static TodoListDto.Task mapToTasksListDto(Task task) {
        TodoListDto.Task tasksDto = new TodoListDto.Task();
        tasksDto.setText(task.getText());
        return tasksDto;
    }

}
