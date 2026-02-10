package classes_ComparableComparator;
import classes_ComparableComparator.classes.Animal;
import classes_ComparableComparator.classes.Dog;
import classes_ComparableComparator.classes.Bird;
import classes_ComparableComparator.classes.Fly;
import classes_ComparableComparator.classes.Mammal;
import classes_ComparableComparator.classes.Platypus;
import classes_ComparableComparator.classes.Animal.CompareName;

import java.util.Collections;
import java.util.List;

import classes_ComparableComparator.Interface.CanFly;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Animal d = new Dog("Perry");
        Animal b = new Bird("Tweety", 12);
        Animal b4 = new Bird("Twarty", 1);
        Animal b2 = new Bird("Tweety", 1);
        Animal b3 = new Bird("Tweety", 26);
        Animal f = new Fly("Langaw", 1);
        Animal p = new Platypus("Perry", 4);

        Animal[] anim = {d, b, f, p, b2, b3, b4};
        List<Animal> animalList = new ArrayList<>();
        for(Animal a: anim){
            animalList.add(a);
        }
        //Collections.sort(animalList);
        animalList.sort(new Animal.CompareName());
        for (Animal a : animalList) {
            System.out.print(a + " ");
            a.makeSound();
            // if(a instanceof CanFly){
            //     System.out.println(((CanFly)a).fly());
            // }
        }
    }
}
