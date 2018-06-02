package pl.braintelligence.todolist.infrastructure.task;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DbTaskRepository extends MongoRepository<DbTasksList, String> {
    Boolean existsByName(String name);
}
