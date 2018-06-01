package pl.braintelligence.todolist.application.utils;

import pl.braintelligence.todolist.application.dto.AllTasksDto;
import pl.braintelligence.todolist.application.dto.NewTaskDto;
import pl.braintelligence.todolist.domain.task.Task;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DtoMapper {

    public static Task mapToTask(NewTaskDto newTaskDto) {
        return new Task(
                newTaskDto.getText()
        );
    }

    public static List<AllTasksDto> mapToAllTasksDto(List<Task> tasks) {
        return tasks.stream()
                .map(DtoMapper::mapToAllTasksDto)
                .collect(toList());
    }

    private static AllTasksDto mapToAllTasksDto(Task task) {
        AllTasksDto allTasksDto = new AllTasksDto();
        allTasksDto.setText(task.getText());
        return allTasksDto;
    }


}
