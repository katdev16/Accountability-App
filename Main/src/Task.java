import java.time.Duration;
import java.util.Scanner;

public class Task {
    public String task;
    public int Duration;
    public String completion;


    public String add_task(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter task");

        this.task = myObj.nextLine();  // Read user input
        System.out.println("Task added: " + task);  // Output user input
        return task;
    }

    public int Duration(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter completion time");
        String input = myObj.nextLine();

        Integer.parseInt(input);

        this.Duration = Integer.parseInt(input);;  // Read user input
        System.out.println("Duration: " + Duration+"hr");
        return Duration;
    }


    boolean task_completion(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Completion(y/n)");
        String input = myObj.nextLine();

        this.completion=input;

        if(input.equals("y")){
            System.out.println("DONE");
        }else if(input.equals("n")){
            System.out.println("NOT DONE");
        }



        return true;
    }

    void reason(){

        System.out.println("Reason: ");
    }

    public void main(String[] args) {
        add_task();
        Duration();
        task_completion();
    }

}





