package classes_Inheritance.Classes;

//

public class Smartphones {
    protected String brand, model, network, display, soc;

    //constructor
    public Smartphones(String model, String network, String display, String soc){
        this.model = model;
        this.network = network;
        this.display = display;
        this.soc = soc;
    }

    //Default constructor is needed 
    //public Smartphones(){} not included for demonstration sake

    public void displaySpecs(){
        System.out.println("Model: " + model);
        System.out.println("Network: " + network);
        System.out.println("Display Type: " + display);
        System.out.println("SoC: " + soc);
    }
}
