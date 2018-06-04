package pl.braintelligence.todolist.application.utils;

import pl.braintelligence.todolist.application.dto.NewTaskDto;
import pl.braintelligence.todolist.application.dto.NewTasksListDto;
import pl.braintelligence.todolist.application.dto.TasksListDto;
import pl.braintelligence.todolist.domain.taskslist.Task;
import pl.braintelligence.todolist.domain.taskslist.TasksList;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DtoMapper {

    public static TasksList mapToTasksList(NewTasksListDto newTasksListDto) {
        return new TasksList(
                newTasksListDto.getName()
        );
    }

    public static List<TasksListDto> mapToTasksListDto(List<TasksList> tasksLists) {
        return tasksLists.stream()
                .map(DtoMapper::mapToTasksListDto)
                .collect(toList());
    }

    private static TasksListDto mapToTasksListDto(TasksList tasksList) {
        TasksListDto tasksListDto = new TasksListDto();
        tasksListDto.setName(tasksList.getName());
        return tasksListDto;
    }

    public static Task mapToTask(NewTaskDto newTaskDto) {
        return new Task(
                newTaskDto.getText()
        );
    }

}
