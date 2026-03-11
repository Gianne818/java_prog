package feb27;

public class NamedRunnable implements Runnable{
    private String name;
    public NamedRunnable(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("Hello, " + name);
//        while(true);
    }
}
