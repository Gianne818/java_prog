package classes_ComparableComparator.classes;

import classes_ComparableComparator.Interface.CanFly;
import classes_ComparableComparator.Interface.EggLayers;

public class Bird extends Animal implements EggLayers, CanFly{
    public Bird(String name, int age){
        super(name, age);
    }


    

    public void setAge(int age){
        this.age = age;
    }

    public int layEggs(){
        return 5;
    }

    public String getName(){
        return name;
    }

    public String fly(){
        return CanFly.super.fly();
    }

    public void makeSound(){
        System.out.println("Tweet!");
    }

    // // import java.util.Comparator;
    // public int compareTo(Shape o){
    //     return this.color.toLowerCase().compareTo(o.color.toLowerCase());
    // }

    // public class ColorCompare implements Comparator<Shape>{
    //     public int compare(Shape o1, Shape o2){
    //         return o1.color.compareTo(o2.color) != 0 ? o1.color.compareTo(o2.color) : Double.compare(o1.area(), o2.area());
    //     }
    // }

}
