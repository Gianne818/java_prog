package classes_ComparableComparator.classes;
import classes_ComparableComparator.Interface.CanFly;

public class Fly extends Animal implements CanFly {
    public Fly(String name, int age){
        super(name, age);
    }

    public void setAge(int age){
        this.age = age;
    }

    public void makeSound(){
        System.out.println("Bzzzz");
    }

    public String getName(){
        return name;
    }

    public String fly(){
        return CanFly.super.fly();
    }
}
