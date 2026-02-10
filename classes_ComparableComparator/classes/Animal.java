package classes_ComparableComparator.classes;
import java.util.Comparator;

public abstract class Animal implements Comparable<Animal> {
    String name;
    int age;
    static int count;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public abstract void makeSound();
    public abstract void setAge(int age);

    public String toString(){
        return name + " " + age;
    }

    //Comparable
    // public int compareTo(Animal o){
    //     return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    // }

    //Comparator
    // public static class CompareName implements Comparator<Animal>{
    //     public int compare(Animal o1, Animal o2){
    //         return o1.compareTo(o2) != 0 ? o1.compareTo(o2) : Integer.compare(o1.age, o2.age);
    //     }
    // }

    public int compareTo(Animal o){
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }

    public static class CompareName implements Comparator<Animal>{
        public int compare(Animal o1, Animal o2){
            return o1.compareTo(o2) != 0 ? o1.compareTo(o2) : Integer.compare(o1.age, o2.age);
        }
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
