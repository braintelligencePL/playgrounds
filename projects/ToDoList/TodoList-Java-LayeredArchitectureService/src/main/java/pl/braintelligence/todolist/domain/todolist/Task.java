package pl.braintelligence.todolist.domain.todolist;

import pl.braintelligence.todolist.domain.values.Status;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.EMPTY_TASK_TEXT;
import static pl.braintelligence.todolist.domain.exceptions.PreCondition.when;

public class Task {

    private String text;
    private Status status;

    public Task(String text, Status status) {
        validateText(text);
        this.text = text;
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public Status getStatus() {
        return status;
    }

    private void validateText(String text) {
        when(isBlank(text))
                .thenInvalidEntity(EMPTY_TASK_TEXT, "Error creating list - name is empty.");
    }

}
