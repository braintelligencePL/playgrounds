package pl.braintelligence.todolist.domain.task;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static pl.braintelligence.todolist.domain.exceptions.ErrorCode.EMPTY_TASK_TEXT;
import static pl.braintelligence.todolist.domain.exceptions.PreCondition.when;

public class Task {

    private String text;

    public Task(String text) {
        validateText(text);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    private void validateText(String text) {
        when(isBlank(text))
                .thenInvalidEntity(EMPTY_TASK_TEXT, "Error creating task");
    }
}
