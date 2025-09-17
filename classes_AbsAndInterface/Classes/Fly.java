package classes_AbsAndInterface.Classes;
import classes_AbsAndInterface.Interface.CanFly;

public class Fly extends Animal implements CanFly {
    Fly(String name, int age){
        super(name, age);
    }

    public void setAge(int age){
        this.age = age;
    }

    public void makeSound(){
        System.out.println("Bzzzz");
    }

    public void fly(){
        System.out.println(name + " is flying.");
    }
}
