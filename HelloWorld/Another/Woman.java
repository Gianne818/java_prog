package HelloWorld.Another;

public class Woman extends Person {
    public void dance() {
        System.out.println(name + " is dancing.");
    }

    public Woman (String name, int age){
        this.name = name;
        this.age = age;
    }
}