package EmployeeANdCustomer;

public abstract class Employee extends Person{
    private double salary;
    final private String ID;
    
    public Employee(String name, int age, double salary, String ID){
        super(name, age);
        this.ID = ID;
        setSalary(salary);
    }
    
    public Employee(String name, int age, String ID){
        super(name, age);
        this.ID = ID;
        setSalary(501.25);
    }
    
    public void setSalary(double salary){
        if(salary >= 501.25){
            this.salary = salary;
        }
    }
    
    public String getID(){
        return ID;
    }
    
    public double getSalary(){
        return salary;
    }
    
}
