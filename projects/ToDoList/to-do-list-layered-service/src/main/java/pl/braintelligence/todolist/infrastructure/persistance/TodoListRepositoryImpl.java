package pl.braintelligence.todolist.infrastructure.persistance;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import pl.braintelligence.todolist.domain.taskslist.TodoList;
import pl.braintelligence.todolist.domain.taskslist.TodoListRepository;
import pl.braintelligence.todolist.infrastructure.taskslist.DbTodoList;
import pl.braintelligence.todolist.infrastructure.taskslist.DbTodoListRepository;

import java.util.List;

@Repository
public class TodoListRepositoryImpl implements TodoListRepository {

    private DbTodoListRepository dbTodoListRepository;

    private MongoOperations mongo;

    public TodoListRepositoryImpl(DbTodoListRepository dbTodoListRepository, MongoTemplate mongo) {
        this.dbTodoListRepository = dbTodoListRepository;
        this.mongo = mongo;
    }

    @Override
    public void save(TodoList todoList) {
        dbTodoListRepository.save(DbTodoList.fromTasksList(todoList));
    }

    @Override
    public Boolean existsByName(String name) {
        return dbTodoListRepository.existsById(name);
    }

    @Override
    public List<TodoList> findAll() {
        return DbTodoList.toTasksList(dbTodoListRepository.findAll());
    }

    @Override
    public TodoList findByName(String name) {

        DbTodoList dbTodoList = mongo.findById(name, DbTodoList.class);

        if(dbTodoList != null) {
            return DbTodoList.toTasksList(dbTodoList);
        }

        return null;
    }

}
