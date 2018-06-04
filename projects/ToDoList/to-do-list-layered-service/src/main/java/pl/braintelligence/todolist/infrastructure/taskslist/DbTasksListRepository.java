package pl.braintelligence.todolist.infrastructure.taskslist;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DbTasksListRepository extends MongoRepository<DbTasksList, String> {
    Boolean existsByName(String name);
}
