package pl.braintelligence.todolist.application;

import org.springframework.stereotype.Service;
import pl.braintelligence.todolist.application.dto.NewTasksListDto;
import pl.braintelligence.todolist.application.dto.TasksListDto;
import pl.braintelligence.todolist.domain.taskslist.TasksList;
import pl.braintelligence.todolist.domain.taskslist.TasksListRepository;

import java.util.List;

import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToTasksList;
import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToTasksListDto;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.LIST_ALREADY_EXISTS;
import static pl.braintelligence.todolist.domain.exceptions.PreCondition.when;


@Service
public class TasksListService {

    private TasksListRepository tasksListRepository;

    public TasksListService(TasksListRepository tasksListRepository) {
        this.tasksListRepository = tasksListRepository;
    }

    public void createNewTasksList(NewTasksListDto newTasksListDto) {

        when(tasksListRepository.existsByName(newTasksListDto.getName()))
                .thenEntityAlreadyExists(LIST_ALREADY_EXISTS, "List named " + newTasksListDto.getName() + " already exists.");

        tasksListRepository.save(mapToTasksList(newTasksListDto));
    }

    public List<TasksListDto> getTasksLists() {
        List<TasksList> tasksLists = tasksListRepository.findAll();
        return mapToTasksListDto(tasksLists);
    }


}
