package HelloWorld.Another;

public class Man extends Person{
    public void eat(){
        System.out.println(name + " is eating.");
    }

    public Man(String name, int age){
        this.name = name;
        this.age = age;
    }
}
