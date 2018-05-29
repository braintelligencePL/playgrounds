package pl.braintelligence.todolist.application;

import org.springframework.stereotype.Service;
import pl.braintelligence.todolist.application.dto.NewTask;

import java.util.List;

@Service
public class TaskService {

    public void createTask(NewTask newTask) {
        System.out.println("sd");
        System.out.println(newTask.getText());
    }

}
