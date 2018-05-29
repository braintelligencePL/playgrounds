package pl.braintelligence.todolist.infrastructure.error;


import pl.braintelligence.todolist.domain.exceptions.ErrorCode;

class ErrorMessage {

    private ErrorCode code;

    ErrorMessage(ErrorCode code) {
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }
}