package classes_AbsAndInterface.Classes;


public abstract class Mammal extends Animal{

    public Mammal(String name, int age){
        super(name, age);
    }

    abstract Mammal giveBirth(String name);
}
