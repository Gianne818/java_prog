package EmployeeANdCustomer;


public class Manager extends Employee{
    public Manager(String name, int age, double salary, String ID){
        super(name, age, salary, ID);
    }
    
    public Manager(String name, int age, String ID){
        super(name, age, ID);
    }
    
    public void giveRaise(Developer d){
        String dName = d.getName();
        System.out.println("You have been so hardworking, " + dName + ". I, " + getName() + " will raise your salary by PHP1000");
        double dSal = d.getSalary();
        d.setSalary(dSal + 1000);
    }
    
    public void work(Developer d){
        String dName = d.getName();
        System.out.println("Hi! I am " + getName() + ". Can you program this for me, " + dName + "?");
        double dSal = d.getSalary();
        d.setSalary(dSal + 25.60);
        d.work();
    }
}
