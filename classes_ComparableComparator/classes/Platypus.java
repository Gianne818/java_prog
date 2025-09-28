package classes_ComparableComparator.classes;
import classes_ComparableComparator.Interface.EggLayers;

public class Platypus extends Mammal implements EggLayers {

    public Platypus(String name, int age){
        super(name, age);
    }

    public Platypus(String name){
        super(name, 1);
    }

    public void makeSound() {
        System.out.println("Kruuu");
    }

    public Mammal giveBirth(String name){
        System.out.println(name + " is a platypus and does not give birth. Laying eggs instead.");
        layEggs();
        return new Platypus(name);
    }

    public void setAge(int age){
        this.age = age;
    }

    public int layEggs(){
        System.out.println(name + " lays eggs.");
        return 1;
    }
}
