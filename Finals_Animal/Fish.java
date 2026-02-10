package Finals_Animal;

public class Fish extends Animal implements Swimmable{
     public Fish(String name){
        super(name);
    }

    public Fish(String name, boolean asleep){
        super(name, asleep);
    }

    public void makeSound(){
        if(getAsleep()){
            System.out.println(name + " Bloop");
        } else {
            System.out.println(name + " is Asleep");
        }
    }

    public void swim(int speed) {
        if(speed < 0){
            throw new IllegalArgumentException();
        }

        if (getAsleep()){
            throw new IllegalStateException();
        }

        System.out.println(name + " swims at a speed of " + speed + " km/h");
    }
}
