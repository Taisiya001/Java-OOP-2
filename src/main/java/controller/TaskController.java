package controller;

import model.Repository;
import model.Task;

import java.util.List;

public class TaskController {
    private Repository repository;

    public TaskController(Repository repository) {
        this.repository = repository;
    }

    public void saveTask(Task task){
        repository.CreateTask(task);
    }
    public Task readTask(String taskId) throws Exception{
        List<Task> tasks = repository.getAllTask();
        for (Task task: tasks){
            if(task.getId().equals(taskId)){
                return task;
            }
        }
        throw new Exception("Task not found");
    }
    public List<Task> readUsers(){
        return repository.getAllTask();
    }

    public void validateUserData(Task task) {
        if ((task.getFirstName()).isEmpty() || (task.getLastName()).isEmpty() ||
                (task.getTerm()).isEmpty()) throw new IllegalStateException("Fields are empty");
    }

    public void editUser(Task task){
        validateUserData(task);
        repository.updateTask(task);
    }
}
