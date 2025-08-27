package classes_ObjectsMethodsConstructors.Classes;

public class Bird {
    float Wingspan;
    String Specie;

    //constructor
    public Bird (String specie, float Wingspan){
        this.Specie = specie;
        this.Wingspan = Wingspan;
    }
    //constructor overloading
    public Bird(){
        this.Specie = "Uknown";
        this.Wingspan = 0.0f;
    }


    public void displayBird(){
        System.out.println("Specie: " + Specie + "\nWingspan: " + Wingspan + "\n");
    }
}
