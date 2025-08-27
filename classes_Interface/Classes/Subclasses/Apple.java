package classes_Interface.Classes.Subclasses;
import classes_Interface.Classes.Smartphones;


public class Apple implements Smartphones {
    protected String brand, model, network, display, soc;

    //constructor
    public Apple(String model, String network, String display, String soc){
        this.brand = "Apple";
        this.model = model;
        this.network = network;
        this.display = display;
        this.soc = soc;
    }

    @Override
    public void displaySpecs(){
        System.out.println("Model: " + model);
        System.out.println("Network: " + network);
        System.out.println("Display Type: " + display);
        System.out.println("SoC: " + soc);
    }

    @Override
    public void displayBrand(){
        System.out.println(brand);
    }
     
}
