package Finals_Animal;

public class Dog extends Animal implements Walkable{

    public Dog(String name){
        super(name);
    }

    public Dog(String name, boolean asleep){
        super(name, asleep);
    }

    public void makeSound(){
        if(getAsleep()){
            System.out.println(name + " Woof");
        } else {
            System.out.println(name + " is Asleep");
        }
    }

    public void walk(int distance){
        System.out.println(name + " walks " + distance + " meters " + ((distance > 0) ? "forward " : "backward ")
            + "using its four legs.");
    }


}
