
import java.util.Scanner;


public class Points {
    private int number;
    private int user_points =0;

//    public int task_point(){
//        this.number+=1;
//        return number;
//    }

//    public int points_for_completion(){
//        number
//    }
    public Points(){
        number=0;
    }
    public void setNumber(){
        Scanner myobj = new Scanner((System.in));

        System.out.println("How many points for this task(1-10 :");
        String input=myobj.nextLine();

        this.number=Integer.parseInt(input);
    }

    public void setUser_points(int user_points){

        this.user_points+=user_points;
    }
    public int getUser_points(){
        return user_points;
    }

    public int getNumber(){

        return this.number;
    }

}

