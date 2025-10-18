package LA_OOP_App.ShapeOfUs;

public class Triangle extends Shape {
    private double base;
    private double height;
    private double a;
    private double c;
    
    public Triangle(double base, double height, double a, double c, String color){
        super(color);
        this.base = base;
        this.height = height;
        this.a = a;
        this.c = c;
    }
    
    public double area(){
        return (1.0/2.0)*base*height;
    }
    
    public double perimeter(){
        return a + base + c;
    }
    
    public String toString(){
        return super.toString() + " which is also a Triangle";
    }
}