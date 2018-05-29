package pl.braintelligence.todolist.domain.exceptions;

public class EntityAlreadyExistsException extends DomainException {

    EntityAlreadyExistsException(String message, ErrorCode code) {
        super(message, code);
    }
}