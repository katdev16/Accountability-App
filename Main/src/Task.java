import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    private String task;
    private int Duration;
    private String completion;

    private String Reason;

    private ArrayList<String> task_list;

    public Task(){
        task=null;
        Duration=0;
        completion=null;
        Reason=null;
    }

    public String add_task(){
        this.task_list= new ArrayList<String>();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter task");

        this.task = myObj.nextLine();  // Read user input
        System.out.println("Task added: " + task);  // Output user input
        task_list.add(task);
//        System.out.println(task_list);

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
            reason();
        }
        return true;
    }

    void reason(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter reason for not completing");
        String input = myObj.nextLine();

        this.Reason= input;
        System.out.println("Reason: "+Reason);
    }

    public ArrayList<String> task_viewer(){


        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("View task dashboard(y/n)");
        String input = myObj.nextLine();
        if(input.equals("y")){
            System.out.println(task_list);
        }

        return this.task_list;
    }


    public void main(String[] args) {
        add_task();
        Duration();
        task_completion();
        task_viewer();
    }

}





