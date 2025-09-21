package classes_Wrapper;

//Wrapper classes in Java provide a way to treat primitive data types as objects. 
//They encapsulate the primitive values and provide useful methods to operate on them.
//Useful when using collections frameworks like ArrayList<> which accepts only objects
public class Main {
    public static void main (String[] args){
        int n = 1;
        Integer number = n;//autoboxing

        System.out.println(number);

        int b = number.intValue();//unboxing
        System.out.println(b);

        String c = "21";
        Integer c1 = Integer.parseInt(c);
        System.out.println(c1);


        int d = c1;
        System.out.println(d);

        String s = Integer.toString(d);
        System.out.println(s);
    }
}