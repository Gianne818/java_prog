package LA_OOP_App.ShapeOfUs;

public class Ellipse extends Shape {
    private double a;
    private double b;
    
    public Ellipse(double a, double b, String color){
        super(color);
        this.a = a;
        this.b = b;
    }
    
    public double area(){
        return Math.PI*a*b;
    }
    
    public double perimeter(){
        double res1 = 3 * (a+b);
        double res2 = Math.sqrt((a+(3*b))*(b+(3*a)));
        double res3 = res1 - res2;
        return Math.PI * res3;
    }
    
    public String toString() {
        return super.toString() + " which is also an Ellipse";
    }
}