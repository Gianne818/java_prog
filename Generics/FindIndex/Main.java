package FindIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // DO NOT MODIFY the main function
    public static void main(String[] args) {
        List<String> stringList;
        List<Integer> integerList;
        List<Double> doubleList;
        List<Animal> animalList;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter test case: ");
        int tc = sc.nextInt();
        switch (tc) {
            case 1:
                stringList = new ArrayList<>();
                stringList.add("Jay");
                stringList.add("Vince");
                stringList.add("Serato");
                stringList.add("Cool");
                stringList.add("And");
                stringList.add("Normal");
                System.out.println("Index: " + findIndexOfElement(stringList, "Cool"));
                break;
            case 2:
                stringList = new ArrayList<>();
                stringList.add("Jay");
                stringList.add("Vince");
                stringList.add("Serato");
                stringList.add("Cool");
                stringList.add("And");
                System.out.println("Index: " + findIndexOfElement(stringList, "Normal"));
                stringList.add("Normal");
                System.out.println("Index: " + findIndexOfElement(stringList, "Normal"));
                break;
            case 3:
                integerList = new ArrayList<>();
                integerList.add(-3);
                integerList.add(4);
                integerList.add(13);
                integerList.add(2006);
                integerList.add(15);
                integerList.add(68);
                System.out.println("Index: " + findIndexOfElement(integerList, 4));
                break;
            case 4:
                integerList = new ArrayList<>();
                integerList.add(-3);
                integerList.add(4);
                integerList.add(13);
                integerList.add(2006);
                System.out.println("Index: " + findIndexOfElement(integerList, 14));
                integerList.add(14);
                System.out.println("Index: " + findIndexOfElement(integerList, 14));
                break;
            case 5:
                doubleList = new ArrayList<>();
                doubleList.add(-3.2);
                doubleList.add(4.0);
                doubleList.add(13.542);
                doubleList.add(2006.1534);
                doubleList.add(15.0);
                doubleList.add(68.153);
                System.out.println("Index: " + findIndexOfElement(doubleList, 13.542));
                break;
            case 6:
                doubleList = new ArrayList<>();
                doubleList.add(-3.4524);
                doubleList.add(4.452);
                doubleList.add(13.4);
                doubleList.add(2006.45);
                System.out.println("Index: " + findIndexOfElement(doubleList, 14.4684));
                doubleList.add(14.4684);
                System.out.println("Index: " + findIndexOfElement(doubleList, 14.4684));
                break;
            case 7:
                animalList = new ArrayList<>();
                animalList.add(new Animal("Jay", 6));
                animalList.add(new Animal("Vince", 2));
                animalList.add(new Animal("Serato", 10));
                animalList.add(new Animal("Vincent", 2));
                animalList.add(new Animal("Coal", 4));
                animalList.add(new Animal("Norma", 5));
                System.out.println("Index: " + findIndexOfElement(animalList, new Animal("jay", 6)));
                break;
            case 8:
                animalList = new ArrayList<>();
                animalList.add(new Animal("Jay", 6));
                animalList.add(new Animal("Vince", 2));
                System.out.println("Index: " + findIndexOfElement(animalList, new Animal("coal", 4)));
                animalList.add(new Animal("Coal", 4));
                System.out.println("Index: " + findIndexOfElement(animalList, new Animal("coal", 4)));
                break;
        }
    }

    // TODO implement findIndexOfElement method here
    
    private static <T> int findIndexOfElement(List<T> list, T elem){

        // int index = 0;
        // for(T val : list){
        //     // if(val instanceof Animal){
        //     //     String name = val.getName().toLowerCase();
        //     //     if (name.equals(elem)){
        //     //         return index;
        //     //     }
        //     // }
            
        //     if(val == elem){
        //         return index;
        //     }
        //     index++;
            
        // }
        
        for(int i = 0; i<list.size(); i++){

            if(list.get(i).equals(elem)){
                return i;
            }
        }
        return -1;
    }

}