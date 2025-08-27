package classes_ObjectsMethodsConstructors;
import classes_ObjectsMethodsConstructors.Classes.Bird;

public class Main {
    public static void main (String[] args){
        Bird b1 = new Bird("Budgie", 5.5f);
        Bird b2 = new Bird("Cockatiel", 5.5f);

        b1.displayBird();
        b2.displayBird();

    }
}
