package pl.braintelligence.todolist.domain.taskslist;

import java.util.List;

public interface TasksListRepository {

    void save(TasksList tasksList);

    void save(Task task, TasksList tasksList);

    Boolean existsByName(String name);

    List<TasksList> findAll();

    TasksList findByName(String name);
}
