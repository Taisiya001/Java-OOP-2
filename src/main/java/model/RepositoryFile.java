package model;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class RepositoryFile implements Repository{
    private TaskMapper mapper = new TaskMapper();
    private FileOperation fileOperation;
    public RepositoryFile(FileOperation fileOperation){this.fileOperation = fileOperation;}
    @Override
    public List<Task> getAllTask() {
        List<String> lines = fileOperation.readAllLines();
        List<Task> tasks = new ArrayList<>();
        for (String line : lines) {
            tasks.add(mapper.map(line));
        }
        return tasks;
    }

    @Override
    public String CreateTask(Task task) {
        List<Task> tasks = getAllTask();
        int max;
        max = 0;
        for (Task item : tasks) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        task.setId(id);
        saveTask(task, tasks);
        return id;
    }
    public void updateTask(Task task){
        deleteTask(task.getId());
        List<Task> tasks = getAllTask();
        saveTask(task,tasks);
    }
    private void saveTask(Task task, List<Task> tasks) {
        tasks.add(task);
        saveTask(tasks);
    }

    public void deleteTask(String taskID){
        List<Task> task = getAllTask();
        task.remove(findTask(taskID, task));
        saveTask(task);
    }

    private Task findTask(String taskID, List<Task> tasks) {
        for (Task task : tasks) {
            if (task.getId().equals(taskID)) {
                return task;
            }
        }
        throw new IllegalStateException("User not found!");
    }

    private void saveTask(List<Task> tasks){
        List<String> lines = new ArrayList<>();
        for (Task item: tasks) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }
}


