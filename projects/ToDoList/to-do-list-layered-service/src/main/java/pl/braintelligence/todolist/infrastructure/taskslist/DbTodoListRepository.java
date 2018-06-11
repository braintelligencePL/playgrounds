package pl.braintelligence.todolist.infrastructure.taskslist;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DbTodoListRepository extends MongoRepository<DbTodoList, String> {
}
