package classes_Interface.Classes.Subclasses;


public class Galaxy extends Samsung {
    private String os;
    
    public Galaxy (String model, String network, String display, String soc, String os){
        super(model, network, display, soc);
        this.os = os;
    }

    public void displayOSVersion(){
        System.out.println("Android Version: " + os);
    }
}
