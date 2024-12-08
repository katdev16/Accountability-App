package com.katdev.accountabilityapp.model;

import com.katdev.accountabilityapp.service.Points;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Scanner;

@Entity
public class Task {


    public Task(){

        Duration=0;
        completion=false;
//        Reason=null;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user;
    private String task;
    private int Duration;
    private boolean completion;

    public boolean isCompletion() {
        return completion;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

//    private String Reason;

//    private ArrayList<String> task_list;
//
//    public Points points = new Points();

//    public String add_task(){
//        this.task_list= new ArrayList<String>();
//
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter task");
//
//        this.task = myObj.nextLine();  // Read user input
//        System.out.println("com.katdev.accountabilityapp.model.Task added: " + task);  // Output user input
//        setNumber();
//        task_list.add(task);
////        System.out.println(task_list);
//
//        return task;
//    }

//    public int Duration(){
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter completion time");
//        String input = myObj.nextLine();
//
//        Integer.parseInt(input);
//
//        this.Duration = Integer.parseInt(input);;  // Read user input
//        System.out.println("Duration: " + Duration+"hr");
//        return Duration;
//    }


//    boolean task_completion(){
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Completion(y/n)");
//        String input = myObj.nextLine();
//
//        this.completion=input;
//
//
//        if(input.equals("y")){
//            System.out.println("DONE");
//            setUser_points(getNumber());
//
//
//        }else if(input.equals("n")){
//            System.out.println("NOT DONE");
//            reason();
//        }
//        return true;
//    }

//    void reason(){
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter reason for not completing");
//        String input = myObj.nextLine();
//
//        this.Reason= input;
//        System.out.println("Reason: "+Reason);
//    }

//    public ArrayList<String> task_dashboard(){
//
//
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("View task dashboard(y/n)");
//        String input = myObj.nextLine();
//        if(input.equals("y")){
//            System.out.println(task_list);
//
//
//
//            System.out.println("com.katdev.accountabilityapp.service.Points :"+getUser_points());
//
//        }
//
//        return this.task_list;
//    }

}





