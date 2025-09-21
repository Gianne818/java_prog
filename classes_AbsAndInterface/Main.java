package classes_AbsAndInterface;
import classes_AbsAndInterface.Classes.Bird;
import classes_AbsAndInterface.Classes.Dog;
import classes_AbsAndInterface.Classes.Fly;
import classes_AbsAndInterface.Classes.Platypus;
import classes_AbsAndInterface.Classes.Animal;
import classes_AbsAndInterface.Classes.Mammal;
import classes_AbsAndInterface.Interface.EggLayers;
import classes_AbsAndInterface.Interface.CanFly;

public class Main {
    public static void main(String[] args) {
        Bird b = new Bird("Tweety", 1);
        Dog d = new Dog("Browny" );
        Fly f = new Fly("Langaw", 1);
        Platypus p = new Platypus("Perry", 5);

        Animal[] animals = {b, d, f, p};

        for (Animal a : animals){
            a.makeSound();
            if(a instanceof Mammal){
                Mammal m = ((Mammal)a).giveBirth("Noname");
                System.out.println("New animal: " + m.getName());
            }

            if(a instanceof EggLayers){
                int numEggs = ((EggLayers)a).layEggs();
                System.out.println( a.getName()+ " has laid " + numEggs + " egg/s.");
            }

            if(a instanceof CanFly){
                ((CanFly)a).fly();
            }
        }

        System.out.println("-------------");
        System.out.println("All animals:");
        for(Animal a : animals){
            System.out.println(a.getName());
        }

    }
}
