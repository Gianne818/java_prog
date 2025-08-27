package classes_Interface.Classes.Subclasses;
import classes_Interface.Classes.Smartphones;

public class Samsung implements Smartphones {
    protected String brand, model, network, display, soc;
   // brand = "Samsung";   cannot assign values directly 

    public Samsung(String model, String network, String display, String soc){
        this.brand = "Samsung";
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
