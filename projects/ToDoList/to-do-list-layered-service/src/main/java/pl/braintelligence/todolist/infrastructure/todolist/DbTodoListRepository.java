package pl.braintelligence.todolist.infrastructure.todolist;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DbTodoListRepository extends MongoRepository<DbTodoList, String> {
}
