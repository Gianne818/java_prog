package Oct6_ExceptionHandling;

public class NameException extends Exception{
    public NameException(String name){
        super("Invalid name: " + name);
    }

    public NameException(){
        super();
    }
}
