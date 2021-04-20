package railway;

import java.util.*;

public class Book {

    Booking b = new Booking();

    int age,child_age;
    String gender, name, berth,child="no";
    
    Scanner sc = new Scanner(System.in);

    public void add() {
        
        System.out.println("Enter your First name");
        this.name = sc.nextLine();
        System.out.println("Enter your age");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your gender");
        this.gender = sc.nextLine();
        if(gender.equalsIgnoreCase("female")){
            System.out.println("Travelling with child age less than 5 Yes/No?");
            child=sc.nextLine();
            
        }
        System.out.println("Enter your berth preference");
        this.berth = sc.nextLine();
        if((age>60) ||((gender.equalsIgnoreCase("female"))&&(child.equalsIgnoreCase("yes")))){
        this.berth="lower";
        }
       
        
        
        
        
    }

    public void prepare_chart() {
        b.prepare_chart();
    }

}
