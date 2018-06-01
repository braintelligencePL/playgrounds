package pl.braintelligence.todolist.infrastructure.task;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DbTaskRepository extends MongoRepository<DbTask, String> {}
