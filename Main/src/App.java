
public class App {
    public static void main(String[] args) {

        Users user = new Users();
        user.add_username();
        user.add_email();
        user.Make_password();

        Task task = new Task();

        task.add_task();
        task.Duration();
        task.task_completion();
        task.task_viewer();


    }
}
