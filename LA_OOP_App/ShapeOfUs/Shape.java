package LA_OOP_App.ShapeOfUs;

import java.util.Comparator;
// Add Comparable and Comparator interface implementation here

public abstract class Shape implements Comparable<Shape>{
    String color;

    public Shape(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "A shape that is color " + color;
    }
    
    public int compareTo(Shape o){
        int res = this.color.toLowerCase().compareTo(o.color.toLowerCase());
        return res == 0 ? -Double.compare(this.area(), o.area()) : res;
    }

    public abstract double area();
    public abstract double perimeter();
    
    public static class AreaComparator implements Comparator<Shape>{
        public int compare(Shape o1, Shape o2){
            return -Double.compare(o1.area(), o2.area());
        }
    }
    
    public static class PerimComparator implements Comparator<Shape>{
        public int compare(Shape o1, Shape o2){
            return -Double.compare(o1.perimeter(), o2.perimeter());
        }
    }
    

}