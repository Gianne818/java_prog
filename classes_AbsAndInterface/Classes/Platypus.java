package classes_AbsAndInterface.Classes;
import classes_AbsAndInterface.Interface.EggLayers;

public class Platypus extends Mammal implements EggLayers {

    Platypus(String name, int age){
        super(name, age);
    }

    Platypus(String name){
        super(name, 1);
    }

    public void makeSound() {
        System.out.println("Kruuu");
    }

    public Mammal giveBirth(String name){
        layEggs();
        return new Platypus(name);
    }

    public void setAge(int age){
        this.age = age;
    }

    public int layEggs(){
        return 1;
    }
}
