package pl.braintelligence.todolist.domain.taskslist;

import pl.braintelligence.todolist.domain.values.TaskState;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.EMPTY_TASK_TEXT;
import static pl.braintelligence.todolist.domain.exceptions.PreCondition.when;

public class Task {

    private String text;
    private TaskState taskState;

    public Task(String text, TaskState taskState) {
        validateText(text);
        this.text = text;
        this.taskState = taskState;
    }

    public String getText() {
        return text;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    private void validateText(String text) {
        when(isBlank(text))
                .thenInvalidEntity(EMPTY_TASK_TEXT, "Error creating list - name is empty.");
    }

}
