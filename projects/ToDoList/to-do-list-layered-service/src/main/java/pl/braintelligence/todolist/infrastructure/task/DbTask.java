package pl.braintelligence.todolist.infrastructure.task;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.braintelligence.todolist.domain.task.Task;

import java.time.Clock;
import java.time.Instant;

@Document(collection = "tasks")
public class DbTask {

    @Id
    private String id;
    private String text;
    private Instant createdAt;

    public DbTask(String text, Instant createdAt) {
        this.text = text;
        this.createdAt = createdAt;
    }

    public static DbTask fromTask(Task task) {
        return new DbTask(
                task.getText(),
                Instant.now(Clock.systemUTC())
        );
    }

    public static Task toTasks(DbTask dbTask) {
        return new Task(
                dbTask.text
        );
    }
}
