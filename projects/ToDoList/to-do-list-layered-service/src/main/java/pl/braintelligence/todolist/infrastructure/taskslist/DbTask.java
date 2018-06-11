package pl.braintelligence.todolist.infrastructure.taskslist;

import org.springframework.data.annotation.Id;
import pl.braintelligence.todolist.domain.taskslist.Task;
import pl.braintelligence.todolist.domain.values.Status;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DbTask {

    @Id
    private String text;
    private Status status;

    public DbTask(String text, Status status) {
        this.text = text;
        this.status = status;
    }

    public static List<Task> toTask(List<DbTask> dbTasks) {
        return dbTasks.stream()
                .map(DbTask::toTask)
                .collect(toList());
    }

    private static Task toTask(DbTask dbTask) {
        return new Task(
                dbTask.text,
                dbTask.status);
    }

}
