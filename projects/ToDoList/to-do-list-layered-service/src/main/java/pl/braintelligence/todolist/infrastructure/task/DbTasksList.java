package pl.braintelligence.todolist.infrastructure.task;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.braintelligence.todolist.domain.taskslist.TasksList;

import java.time.Clock;
import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Document(collection = "tasks_list")
public class DbTasksList {

    @Id
    private String id;
    private String name;
    private Instant createdAt;

    private DbTasksList(String name, Instant createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public static DbTasksList fromTasksList(TasksList tasksList) {
        return new DbTasksList(
                tasksList.getName(),
                Instant.now(Clock.systemUTC())
        );
    }

    public static List<TasksList> toTasksList(List<DbTasksList> dbTasksList) {
        return dbTasksList.stream()
                .map(DbTasksList::toTasksList)
                .collect(toList());
    }

    private static TasksList toTasksList(DbTasksList dbTasksList) {
        return new TasksList(
                dbTasksList.name,
                dbTasksList.createdAt
        );
    }

}
