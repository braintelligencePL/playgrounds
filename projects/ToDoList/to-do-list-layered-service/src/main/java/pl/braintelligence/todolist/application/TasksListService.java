package pl.braintelligence.todolist.application;

import org.springframework.stereotype.Service;
import pl.braintelligence.todolist.application.dto.NewTaskDto;
import pl.braintelligence.todolist.application.dto.NewTasksListDto;
import pl.braintelligence.todolist.application.dto.ExistingTasksListDto;
import pl.braintelligence.todolist.application.dto.TasksListDto;
import pl.braintelligence.todolist.domain.taskslist.TasksList;
import pl.braintelligence.todolist.domain.taskslist.TasksListRepository;

import java.util.List;

import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToTask;
import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToTasksList;
import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToExistingTasksListDto;
import static pl.braintelligence.todolist.application.utils.DtoMapper.mapToTasksListDto;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.EMPTY_TASKS_LIST;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.LIST_ALREADY_EXISTS;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.NONEXISTENT_TASKS_LIST;
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

    public List<ExistingTasksListDto> getTasksLists() {

        List<TasksList> tasksLists = tasksListRepository.findAll();

        when(tasksLists.isEmpty())
                .thenMissingEntity(EMPTY_TASKS_LIST, "Error getting tasks lists - none available");

        return mapToExistingTasksListDto(tasksLists);
    }

    public void addTaskToTasksList(String listName, NewTaskDto newTaskDto) {

        TasksList tasksList = tasksListRepository.findByName(listName); // may be optimized (don't take whole object from DB)

        when(tasksList.getName() == null)
                .thenMissingEntity(NONEXISTENT_TASKS_LIST, "Error adding task to '" + listName + "' tasksList - list doesn't exists");

        tasksListRepository.save(mapToTask(newTaskDto), tasksList);

    }

    public TasksListDto getTasksList(String listName) {
        TasksList tasksList = tasksListRepository.findByName(listName);

        return mapToTasksListDto(tasksList);
    }
}
