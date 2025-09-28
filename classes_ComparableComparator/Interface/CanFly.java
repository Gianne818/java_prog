package classes_ComparableComparator.Interface;

public interface CanFly {
    public String getName();
    public default String fly(){
        return getName() + " is flying";
    }
}   
