package pl.braintelligence.todolist.application.utils;

import pl.braintelligence.todolist.application.dto.ExistingTasksListDto;
import pl.braintelligence.todolist.application.dto.NewTaskDto;
import pl.braintelligence.todolist.application.dto.NewTasksListDto;
import pl.braintelligence.todolist.application.dto.TasksListDto;
import pl.braintelligence.todolist.domain.taskslist.Task;
import pl.braintelligence.todolist.domain.taskslist.TasksList;
import pl.braintelligence.todolist.domain.values.TaskState;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DtoMapper {

    public static TasksList mapToTasksList(NewTasksListDto newTasksListDto) {
        return new TasksList(
                newTasksListDto.getName()
        );
    }

    public static List<ExistingTasksListDto> mapToExistingTasksListDto(List<TasksList> tasksLists) {
        return tasksLists.stream()
                .map(DtoMapper::mapToExistingTasksListDto)
                .collect(toList());
    }

    private static ExistingTasksListDto mapToExistingTasksListDto(TasksList tasksList) {
        ExistingTasksListDto existingTasksListDto = new ExistingTasksListDto();
        existingTasksListDto.setName(tasksList.getName());
        return existingTasksListDto;
    }

    public static Task mapToTask(NewTaskDto newTaskDto) {
        return new Task(
                newTaskDto.getText(),
                TaskState.PENDING
        );
    }

    public static TasksListDto mapToTasksListDto(TasksList tasksList) {
        TasksListDto tasksListDto = new TasksListDto();
        tasksListDto.setName(tasksList.getName());
        tasksListDto.setTasks(
                tasksList.getTasks().stream()
                        .map(DtoMapper::mapToTasksListDto)
                        .collect(toList()));
        return tasksListDto;
    }

    private static pl.braintelligence.todolist.application.dto.Task mapToTasksListDto(Task task) {
        pl.braintelligence.todolist.application.dto.Task tasksDto = new pl.braintelligence.todolist.application.dto.Task();
        tasksDto.setText(task.getText());
        return tasksDto;
    }

}
