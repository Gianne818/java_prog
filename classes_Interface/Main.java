package classes_Interface;

import classes_Interface.Classes.Subclasses.Galaxy;
import classes_Interface.Classes.Subclasses.iPhone;

public class Main {
    public static void main (String[] args){
        iPhone a1 = new iPhone("Iphone 14", "5G", "OLED", "A16 Bionic", "26.0");
        Galaxy s1 = new Galaxy("Galaxy S25 Ultra", "5G", "OLED", "Snapdragon 8 Elite", "16.0");
        a1.displayBrand();
        a1.displaySpecs();
        a1.displayOSVersion();

        System.out.println();
        s1.displayBrand();
        s1.displaySpecs();
        s1.displayOSVersion();
        
    }
}
