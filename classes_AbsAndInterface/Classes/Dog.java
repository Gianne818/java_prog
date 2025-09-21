package classes_AbsAndInterface.Classes;

public class Dog extends Mammal{

    public Dog(String name, int age){
        super(name, age);
    }

    public Dog(String name){
        super(name, 1);
    }

    public void makeSound(){
        System.out.println("Woof!");
    }

    public Dog giveBirth(String name){
        System.out.println(this.name + " is giving birth.");
        count++;
        return new Dog(name);
    }

    public void setAge(int age){
        this.age = age;
    }
}
