import java.util.Scanner;

public class Users {
    private String username;
    private String email;
    private String password;

    public Users(){

        username=null;
        email=null;
        password=null;
    }

    public String add_username(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");
        String input = myObj.nextLine();
        System.out.println("Username: " + input);
        return this.username;
    }

    public String add_email(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter email");
        String input = myObj.nextLine();
        System.out.println("Email: " + input);
        return this.email;
    }

    public String Create_password(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a password");


        String input = myObj.nextLine();
        System.out.println("Password: " + input);

        System.out.println("Confirm password");
        String input2 = myObj.nextLine();
        System.out.println("Password: " + input2);
        System.out.println("New password created!!");
        return this.password;
    }



//    public void main(String[] args) {
//        add_username();
//        add_email();
//        Make_password();
//    }


}
