package pl.braintelligence.todolist.infrastructure.persistance;

import org.springframework.stereotype.Repository;
import pl.braintelligence.todolist.domain.taskslist.TasksList;
import pl.braintelligence.todolist.domain.taskslist.TasksListRepository;
import pl.braintelligence.todolist.infrastructure.task.DbTasksList;
import pl.braintelligence.todolist.infrastructure.task.DbTaskRepository;

import java.util.List;

@Repository
public class TasksListRepositoryImpl implements TasksListRepository {

    private DbTaskRepository dbTaskRepository;

    public TasksListRepositoryImpl(DbTaskRepository dbTaskRepository) {
        this.dbTaskRepository = dbTaskRepository;
    }

    @Override
    public void save(TasksList tasksList) {
        dbTaskRepository.save(DbTasksList.fromTasksList(tasksList));
    }

    @Override
    public Boolean existsByName(String name) {
        return dbTaskRepository.existsByName(name);
    }

    @Override
    public List<TasksList> findAll() {
        return DbTasksList.toTasksList(dbTaskRepository.findAll());
    }

}
