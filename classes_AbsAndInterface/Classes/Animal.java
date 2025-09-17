package classes_AbsAndInterface.Classes;

public abstract class Animal {
    String name;
    int age;
    static int count;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();
    public abstract void setAge(int age);
}
