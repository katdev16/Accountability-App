import java.util.Scanner;

public class Users {
    private String username;
    private String email;
    private String password;

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

    public String Make_password(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter password");
        String input = myObj.nextLine();
        System.out.println("Password: " + input);
        return this.password;
    }



    public void main(String[] args) {
        add_username();
        add_email();
        Make_password();
        Make_password();

    }


}
