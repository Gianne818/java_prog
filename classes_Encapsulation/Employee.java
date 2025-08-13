package classes_Encapsulation;
import java.util.Scanner;
//public - accesible to other classes and packages
//private - only accessible within the same class ensuring data hiding and encapsulation
//protected - accessible within the same class.

public class Employee {
    private String name;
    private float salary;
    protected String ID;

    public Employee(String name){
        this.name = name;
        this.salary = 0.0f;
        this.ID = "null";
    }

    //getters
    public String getName(){
        return name;
    }

    private boolean verifyPass(Scanner sc){
        System.out.print("Enter password: ");
        int pass = sc.nextInt();
        sc.nextLine();
        return pass==123456;
    }

    protected float getSalary(Scanner sc){
        if(!verifyPass(sc)){
            System.out.println("Error password.");
            return 0.0f;
        }
        return salary;
    }

    protected String getID(Scanner sc){
        if(!verifyPass(sc)){
            System.out.println("Error password.");
            return "null";
        }
        return ID;
    }

    //setters
    public void setSalary(float newSalary, Scanner sc){
        if(!verifyPass(sc)){
            System.out.println("Error password.");
            return;
        }
        this.salary = newSalary;
        System.out.println("Salary set successfully.");
    }

    public void setID(String newID, Scanner sc){
        if(!verifyPass(sc)){
            System.out.println("Error password.");
            return;
        } 
        this.ID = newID;
        System.out.println("ID set successfully.");
    }

}
