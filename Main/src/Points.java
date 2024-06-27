import java.util.Scanner;

public class Points {
    private int number;

//    public int task_point(){
//        this.number+=1;
//        return number;
//    }

//    public int points_for_completion(){
//        number
//    }
    public void setNumber(){
        Scanner myobj = new Scanner((System.in));
        String input=myobj.nextLine();
        System.out.println("How many points for this task(1-10 :");


        number=+Integer.parseInt(input);
    }

    public int getNumber(){
        return number;
    }
}

