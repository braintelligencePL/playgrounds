package pl.braintelligence.todolist.application;

import org.springframework.stereotype.Service;
import pl.braintelligence.todolist.application.dto.AllTasksDto;
import pl.braintelligence.todolist.application.dto.NewTaskDto;
import pl.braintelligence.todolist.application.utils.DtoMapper;
import pl.braintelligence.todolist.domain.task.Task;
import pl.braintelligence.todolist.domain.task.TaskRepository;

import java.util.List;

import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToTask;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(NewTaskDto newTaskDto) {
        Task task = mapToTask(newTaskDto);
        taskRepository.save(task);
    }

    public List<AllTasksDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return DtoMapper.mapToAllTasksDto(tasks);
    }
}
