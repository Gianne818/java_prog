package HelloWorld;
import HelloWorld.Another.Woman;
import HelloWorld.Another.Man;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        Woman w = new Woman("Sami", 19);
        Man m = new Man ("Gianne", 19);

        System.out.println("Name: " + w.name);
        System.out.println("Age: " + w.age);
        System.out.println("Name: " + m.name);
        System.out.println("Age: " + m.age);
        w.dance();
        m.eat();


    }
}