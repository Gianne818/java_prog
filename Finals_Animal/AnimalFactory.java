package Finals_Animal;
public class AnimalFactory extends AbstractAnimalFactory{
    public Animal createAnimal(String type, String name){
        if(type.equalsIgnoreCase("Dog")){
            return new Dog(name);
        }
        if(type.equalsIgnoreCase("Fish")){
            return new Fish(name);
        }
        // if(type.equalsIgnoreCase("Bird")){
        //     return new Bird(name);
        // }
        throw new IllegalArgumentException("Unknown animal");
    }
}

