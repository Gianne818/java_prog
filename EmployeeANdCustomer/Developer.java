package EmployeeANdCustomer;


public class Developer extends Employee {
    public Developer(String name, int age, double salary, String ID){
        super(name, age, salary, ID);
    }
    
    public Developer(String name, int age, String ID){
        super(name, age, ID);
    }
    
    public void work(){
        System.out.println("I am " + getName() + " and I am programming.");
    }
}
