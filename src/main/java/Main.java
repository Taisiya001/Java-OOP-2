import controller.TaskController;
import model.FileOperation;
import model.FileOperationMpl;
import model.Repository;
import model.RepositoryFile;
import views.ViewTask;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationMpl("task.txt");
        Repository repository = new RepositoryFile(fileOperation);
        TaskController controller = new TaskController(repository);
        ViewTask view = new ViewTask(controller);
        view.run();

    }
}