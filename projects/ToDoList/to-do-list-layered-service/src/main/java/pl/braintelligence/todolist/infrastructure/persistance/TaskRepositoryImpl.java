package pl.braintelligence.todolist.infrastructure.persistance;

import org.springframework.stereotype.Repository;
import pl.braintelligence.todolist.domain.task.Task;
import pl.braintelligence.todolist.domain.task.TaskRepository;
import pl.braintelligence.todolist.infrastructure.task.DbTask;
import pl.braintelligence.todolist.infrastructure.task.DbTaskRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private DbTaskRepository dbTaskRepository;

    public TaskRepositoryImpl(DbTaskRepository dbTaskRepository) {
        this.dbTaskRepository = dbTaskRepository;
    }

    @Override
    public void save(Task task) {
        dbTaskRepository.save(DbTask.fromTask(task));
    }

    @Override
    public List<Task> findAll() {

        List<DbTask> dbtasks = dbTaskRepository.findAll();

        return dbtasks.stream()
                .map(DbTask::toTasks)
                .collect(toList());
    }
}
