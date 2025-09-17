package classes_Interface.Classes;

//An interface is a completely abstract class
//Interface methods are by default abstract and public
//Interface attributes are by default public, static and final
//Cannot contain a constructor and a concrete method.

//Java classes does not support multiple inheritance (only inherit from one superclass). You can do this by using interfaces.
//Override all methods upon implementation
//Interface is more for behavior. For instance, a member of a class insect may have an interface for a behavior canFly


public interface Smartphones {
    //Attributes are final and cannot be changed, so they need to be initalized
//   String brand, model, network, display, soc;   


    //abstract methods
    public void displaySpecs();
    public void displayBrand();


} 
