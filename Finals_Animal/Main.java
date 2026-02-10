package Finals_Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Finals_Animal.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char op;
        List<Animal> animalList = new ArrayList<>();
        AbstractAnimalFactory animalFactory = new AnimalFactory();
        while(true){
            System.out.println("Choices: ");
            System.out.println("a. Enter Animal\n" + "b. Display Animals\n" + "c. Exit");
            System.out.print("Enter choice: ");
            op = sc.nextLine().charAt(0);

            switch(op){
                case 'c':
                    System.out.println("Exiting...");
                    return;
                
                case 'a':
                    System.out.println("Enter animal type: ");
                    String type = sc.nextLine();
                    System.out.println("Enter name: ");
                    String name = sc.nextLine();
                    Animal temp = animalFactory.createAnimal(type, name);
                    animalList.add(temp);
                    break;

                case 'b':
                    animalList.sort(new Animal.CompareName());
                    for(Animal a : animalList){
                        System.out.println(a.name);
                    }

                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}
