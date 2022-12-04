package model;

import java.util.List;

public interface Repository {
    List<Task> getAllTask();
    String CreateTask(Task task);
    void updateTask(Task task);
    void deleteTask(String taskID);
}
