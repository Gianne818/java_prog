package LA_OOP_App.ShapeOfUs;

public class EquilateralTriangle extends Triangle {
    
    public EquilateralTriangle(double side, String color){
        super(side, ((Math.sqrt(3))/2)*side, side, side, color);
    }
    
    public double area(){
        return super.area();
    }
    
    public double perimeter(){
        return super.perimeter();
    }
    
    public String toString(){
        return super.toString() + " which is also an Equilateral Triangle";
    }
}