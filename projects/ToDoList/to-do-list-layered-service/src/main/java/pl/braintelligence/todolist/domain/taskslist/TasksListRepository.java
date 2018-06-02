package pl.braintelligence.todolist.domain.taskslist;

import pl.braintelligence.todolist.infrastructure.task.DbTasksList;

import java.util.List;

public interface TasksListRepository {
    void save(TasksList tasksList);

    Boolean existsByName(String name);

    List<TasksList> findAll();

}
