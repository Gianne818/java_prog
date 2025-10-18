package LA_OOP_App.ShapeOfUs;

public class Circle extends Ellipse {
        private double rad;
        public Circle(double rad, String color){
            super(rad, rad, color);
            this.rad = rad;
        }
        
        public double area(){
            return super.area();
        }
        
        public double perimeter(){
            return 2 * Math.PI * rad;
        }
        
        public String toString() {
            return super.toString() + " which is also a Circle";
        }
}