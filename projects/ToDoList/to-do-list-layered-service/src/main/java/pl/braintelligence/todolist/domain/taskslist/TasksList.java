package pl.braintelligence.todolist.domain.taskslist;

import java.time.Instant;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.EMPTY_LIST_NAME;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.TOO_LONG_LIST_NAME;
import static pl.braintelligence.todolist.domain.exceptions.PreCondition.when;

public class TasksList {

    private String name;
    private List<Task> tasks;
    private Instant createdAt;

    public TasksList(String name) {
        validateName(name);
        this.name = name;
    }

    public TasksList(String name, List<Task> tasks, Instant createdAt) {
        validateName(name);
        this.name = name;
        this.tasks = tasks;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    private void validateName(String text) {
        when(isBlank(text))
                .thenInvalidEntity(EMPTY_LIST_NAME, "Error creating list - name is empty.");
        when(text.length() > 50)
                .thenInvalidEntity(TOO_LONG_LIST_NAME, "Error creating list - too long name for the list.");
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
