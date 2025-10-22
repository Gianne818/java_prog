package EmployeeANdCustomer;

public class Customer extends Person {
    public Customer(String name, int age){
        super(name, age);
    }
    
    public void purchase(String item, double price){
        System.out.printf("%s buys %s worth %.2f", getName(), item, price);
    }
    
    public void purchase(String item, int num){
        System.out.printf("%s buys %d pieces of %s", getName(), num, item);
    }
    
}
