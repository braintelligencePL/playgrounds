package pl.braintelligence.todolist.infrastructure.taskslist;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.braintelligence.todolist.domain.taskslist.Task;
import pl.braintelligence.todolist.domain.taskslist.TasksList;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Document(collection = "tasks_list")
public class DbTasksList {

    @Id
    private String name;
    private List<DbTask> tasks;
    private Instant createdAt;

    private DbTasksList(String name, List<DbTask> tasks, Instant createdAt) {
        this.name = name;
        this.tasks = tasks;
        this.createdAt = createdAt;
    }

    public static DbTasksList fromTasksList(TasksList tasksList) {
        return new DbTasksList(
                tasksList.getName(),
                toDbTask(tasksList.getTasks()),
                Instant.now(Clock.systemUTC())
        );
    }

    private static List<DbTask> toDbTask(List<Task> tasks) {

        if (tasks == null) { //TODO: refactor to Optional.ofNullable
            return new ArrayList<>();
        }

        return tasks.stream()
                .map(DbTasksList::toDbTask)
                .collect(toList());
    }

    public static DbTask toDbTask(Task task) {
        return new DbTask(task.getText());
    }

    public static List<TasksList> toTasksList(List<DbTasksList> dbTasksList) {
        return dbTasksList.stream()
                .map(DbTasksList::toTasksList)
                .collect(toList());
    }

    public static TasksList toTasksList(DbTasksList dbTasksList) {
        return new TasksList(
                dbTasksList.name,
                DbTask.toTask(dbTasksList.tasks),
                dbTasksList.createdAt
        );
    }

}
