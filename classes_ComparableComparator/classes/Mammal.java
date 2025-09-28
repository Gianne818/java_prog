package classes_ComparableComparator.classes;

public abstract class Mammal extends Animal{

    public Mammal(String name, int age){
        super(name, age);
    }

    public abstract Mammal giveBirth(String name);
}
