package pl.braintelligence.todolist.domain.todolist;

import java.util.List;

public interface TodoListRepository {

    void save(TodoList todoList);

    Boolean existsByName(String name);

    List<TodoList> findAll();

    TodoList findByName(String name);
}
