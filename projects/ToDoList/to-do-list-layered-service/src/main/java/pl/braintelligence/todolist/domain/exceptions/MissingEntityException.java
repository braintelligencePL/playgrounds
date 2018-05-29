package pl.braintelligence.todolist.domain.exceptions;

public class MissingEntityException extends DomainException {

    MissingEntityException(String message, ErrorCode code) {
        super(message, code);
    }
}