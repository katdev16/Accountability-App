import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Users user = new Users();
        user.add_username();
        user.add_email();
        user.Create_password();

        Task task = new Task();

        task.add_task();
        task.Duration();
        task.task_completion();
        task.task_dashboard();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Add new task(y/n :");
        String input = myObj.nextLine();
        while (input.equals("y")){

                task.add_task();
                task.Duration();
                task.task_completion();
                task.task_dashboard();
        }



    }
}
