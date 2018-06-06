package pl.braintelligence.todolist.domain.values;

public enum TaskState {

    PENDING,
    COMPLETED,
    INVALID_TASK_STATE;

    public boolean isInvalid() {
        return this == INVALID_TASK_STATE;
    }

}
