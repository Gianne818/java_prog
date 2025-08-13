package classes_AbstractClasses.Classes.Subclasses;
import classes_AbstractClasses.Classes.Smartphones;

public class Samsung extends Smartphones {
    String brand = "Samsung";
    public Samsung(String model, String network, String display, String soc){
        super(model, network, display, soc); //invoke super clas constructor
        this.model = model;
        this.network = network;
        this.display = display;
        this.soc = soc;
    }

    public void displaySpecs(){
        System.out.println("Model: " + model);
        System.out.println("Network: " + network);
        System.out.println("Display Type: " + display);
        System.out.println("SoC: " + soc);
    }

    public void displayBrand(){
        System.out.println(brand);
    }
    
}
