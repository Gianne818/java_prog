package classes_AbsAndInterface.Classes;
import classes_AbsAndInterface.Interface.EggLayers;

public class Bird extends Animal implements EggLayers{
    public Bird(String name, int age){
        super(name, age);
    }

    public void setAge(int age){
        this.age = age;
    }

    public int layEggs(){
        return 5;
    }

    public void makeSound(){
        System.out.println("Tweet!");
    }

}
