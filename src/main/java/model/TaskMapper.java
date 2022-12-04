package model;

public class TaskMapper {
    public String map(Task task){
        return String.format("%s,%s,%s,%s,%s",task.getId(),task.getFirstName(),task.getLastName(),task.getTerm(),task.getPriority());
    }
    public Task map(String line){
        String[] lines = line.split(",");
        return new Task(lines[0], lines[1], lines[2], lines[3],lines[4]);
    }
}
