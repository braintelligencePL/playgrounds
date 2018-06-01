package pl.braintelligence.todolist.domain.task;

import java.util.List;

public interface TaskRepository {

    void save(Task task);

    List<Task> findAll();
}
