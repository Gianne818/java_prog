package classes_AbstractClasses.Classes;

// An abstract class cannot be directly instantiated.
// May contain both abstract and concrete methods.
// Exists to serve as a blueprint for other classes.
// Subclasses must implement all abstract methods.

public abstract class Smartphones {
    protected String brand, model, network, display, soc;

    //constructor
    public Smartphones(String model, String network, String display, String soc){
        this.model = model;
        this.network = network;
        this.display = display;
        this.soc = soc;
    }

    //Default constructor is needed unless you invoke Smartphone constructor on subclasses
    //public Smartphones(){} not included for demonstration sake

    public abstract void displaySpecs();
    public abstract void displayBrand();
}
