package classes_Wrapper;

//Wrapper classes in Java provide a way to treat primitive data types as objects. 
//They encapsulate the primitive values and provide useful methods to operate on them.
//Useful when using collections frameworks like ArrayList<> which accepts only objects.
//Use wrapper classes when working with collections, APIs, or situations that require objects instead of primitive values.
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

        Integer num1 = 1;
        Integer num2 = 2;
        Integer num3 = 1;

        int res1 = num1.compareTo(num2);
        System.out.println(res1);

        int res2 = num1.compareTo(num3);
        System.out.println(res2);


    }
}