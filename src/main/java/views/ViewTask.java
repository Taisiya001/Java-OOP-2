package views;



import controller.TaskController;
import model.Task;

import java.util.Scanner;
import java.util.logging.Logger;

public class ViewTask {

    private TaskController taskController;

    public ViewTask(TaskController taskController) {
        this.taskController = taskController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            Logger logger = Logger.getAnonymousLogger();
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            logger.info(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    try {
                        String firstName = prompt("Имя: ");
                        String lastName = prompt("Фамилия: ");
                        String term = prompt("Срок: ");
                        String priority = prompt("Приоритет: ");
                        taskController.saveTask(new Task(firstName, lastName, term, priority));
                    }
                    catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                case READ:
                    String id = prompt("Идентификатор задачи: ");
                    try {
                        Task task = taskController.readTask(id);
                        System.out.println(task);
                    } catch (Exception e) {
                        throw new RuntimeException(e);}
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
