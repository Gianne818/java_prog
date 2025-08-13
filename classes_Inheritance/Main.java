package classes_Inheritance;
import classes_Inheritance.Classes.Subclasses.Apple;
import classes_Inheritance.Classes.Subclasses.Samsung;

public class Main {
    public static void main (String[] args){
        Apple a1 = new Apple("Iphone 14", "5G", "OLED", "A16 Bionic");
        Samsung s1 = new Samsung("Galaxy S25 Ultra", "5G", "OLED", "Snapdragon 8 Elite");
        a1.displayBrand();
        a1.displaySpecs();

        System.out.println();
        s1.displayBrand();
        s1.displaySpecs();
        
    }
}
