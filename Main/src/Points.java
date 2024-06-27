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
    public Points(){
        number=1;
    }
    public void setNumber(){
        Scanner myobj = new Scanner((System.in));

        System.out.println("How many points for this task(1-10 :");
        String input=myobj.nextLine();

        this.number=Integer.parseInt(input);
        System.out.println(number);
    }

    public int getNumber(){

        return this.number;
    }

}

