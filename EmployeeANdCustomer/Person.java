package EmployeeANdCustomer;

public abstract class Person{
    private final String name;
    private int age;
    
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public void setAge(boolean isBday){
        if (isBday){
            age++;
        }
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
}