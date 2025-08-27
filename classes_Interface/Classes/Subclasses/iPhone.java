package classes_Interface.Classes.Subclasses;

public class iPhone extends Apple {
    private String os;
    public iPhone(String model, String network, String display, String soc, String os) {
        super(model, network, display, soc);
        this.os = os;
    }

    public void  displayOSVersion(){
        System.out.println("iOS Version: " + os);
    }
}
