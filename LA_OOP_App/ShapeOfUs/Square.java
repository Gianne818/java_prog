package LA_OOP_App.ShapeOfUs;

public class Square extends Rectangle {
       public Square(double side, String color) {
            super(side, side, color);
       }
       
       public double area() {
            return super.area();
        }

        @Override
        public double perimeter() {
            return super.perimeter();
        }
        
        public String toString() {
            return super.toString() + " which is also a Square";
        }
   }