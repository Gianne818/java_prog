package Finals_Animal;
import java.util.Comparator;

public abstract class Animal{
    protected final String name;
    private boolean asleep;

    public Animal(String name){
        this.name = name;
    }

    public Animal (String name, boolean asleep){
        this(name);
        this.asleep = asleep;
    }

    public void sleep(){
        asleep = true;
    }

    public void wakeUp(){
        asleep = false;
    }

    public abstract void makeSound();

    public boolean getAsleep(){
        return asleep;
    }

    public int compareTo(Animal o){
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }

    public static class CompareName implements Comparator<Animal>{
        public int compare(Animal o1, Animal o2){
            return o1.compareTo(o2) != 0 ? o1.compareTo(o2) : Boolean.compare(o1.asleep, o2.asleep);
        }
    }
}