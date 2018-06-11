package pl.braintelligence.todolist.infrastructure.todolist;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.braintelligence.todolist.domain.todolist.Task;
import pl.braintelligence.todolist.domain.todolist.TodoList;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Document(collection = "todo_list")
public class DbTodoList {

    @Id
    private String name;
    private List<DbTask> tasks;
    private Instant createdAt;

    private DbTodoList(String name, List<DbTask> tasks, Instant createdAt) {
        this.name = name;
        this.tasks = tasks;
        this.createdAt = createdAt;
    }

    public static DbTodoList fromTasksList(TodoList todoList) {
        return new DbTodoList(
                todoList.getName(),
                toDbTask(todoList.getTasks()),
                Instant.now(Clock.systemUTC())
        );
    }

    private static List<DbTask> toDbTask(List<Task> tasks) {

        if (tasks == null) { //TODO: might be used Optional.ofNullable
            return new ArrayList<>();
        }

        return tasks.stream()
                .map(DbTodoList::toDbTask)
                .collect(toList());
    }

    public static DbTask toDbTask(Task task) {
        return new DbTask(task.getText(), task.getStatus());
    }

    public static List<TodoList> toTasksList(List<DbTodoList> dbTodoList) {
        return dbTodoList.stream()
                .map(DbTodoList::toTasksList)
                .collect(toList());
    }

    public static TodoList toTasksList(DbTodoList dbTodoList) {
        return new TodoList(
                dbTodoList.name,
                DbTask.toTask(dbTodoList.tasks),
                dbTodoList.createdAt
        );
    }

}
