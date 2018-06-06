package pl.braintelligence.todolist.infrastructure.persistance;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import pl.braintelligence.todolist.domain.taskslist.Task;
import pl.braintelligence.todolist.domain.taskslist.TasksList;
import pl.braintelligence.todolist.domain.taskslist.TasksListRepository;
import pl.braintelligence.todolist.infrastructure.taskslist.DbTasksList;
import pl.braintelligence.todolist.infrastructure.taskslist.DbTasksListRepository;

import java.util.List;

@Repository
public class TasksListRepositoryImpl implements TasksListRepository {

    private DbTasksListRepository dbTasksListRepository;

    private MongoOperations mongo;

    public TasksListRepositoryImpl(DbTasksListRepository dbTasksListRepository, MongoTemplate mongo) {
        this.dbTasksListRepository = dbTasksListRepository;
        this.mongo = mongo;
    }

    @Override
    public void save(TasksList tasksList) {
        dbTasksListRepository.save(DbTasksList.fromTasksList(tasksList));
    }

    @Override
    public Boolean existsByName(String name) {
        return dbTasksListRepository.existsById(name);
    }

    @Override
    public List<TasksList> findAll() {
        return DbTasksList.toTasksList(dbTasksListRepository.findAll());
    }

    @Override
    public TasksList findByName(String name) {
        return DbTasksList.toTasksList(mongo.findById(name, DbTasksList.class));
    }

}
