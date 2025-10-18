package LA_OOP_App.ShapeOfUs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shape shape = null;
        Scanner sc = new Scanner(System.in);
        String option;
        double len, wid, side, base, height, a, b, c, r;
        List<Shape> shapes = new ArrayList<>();
        String color;
        do {

        System.out.print("Enter shape: ");
        option = sc.nextLine();
        switch (option) {
            case "Rectangle":
                System.out.print("Enter length: ");
                len = sc.nextDouble();
                System.out.print("Enter width: ");
                wid = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter color: ");
                color = sc.nextLine();
                shape = new Rectangle(len, wid, color);
                shapes.add(shape);
                break;
            case "Square":
                System.out.print("Enter side: ");
                side = sc.nextDouble();
                System.out.print("Enter color: ");
                sc.nextLine();
                color = sc.nextLine();
                shape = new Square(side, color);
                shapes.add(shape);
                break;
            case "Ellipse":
                System.out.print("Enter a: ");
                a = sc.nextDouble();
                System.out.print("Enter b: ");
                b = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter color: ");
                color = sc.nextLine();
                shape = new Ellipse(a, b, color);
                shapes.add(shape);
                break;
            case "Circle":
                System.out.print("Enter radius: ");
                r = sc.nextDouble();
                System.out.print("Enter color: ");
                sc.nextLine();
                color = sc.nextLine();
                shape = new Circle(r, color);
                shapes.add(shape);
                break;
            case "Triangle":
                System.out.print("Enter base: ");
                base = sc.nextDouble();
                System.out.print("Enter height: ");
                height = sc.nextDouble();
                System.out.print("Enter a: ");
                a = sc.nextDouble();
                System.out.print("Enter c: ");
                c = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter color: ");
                color = sc.nextLine();
                shape = new Triangle(base, height, a, c, color);
                shapes.add(shape);
                break;
            case "Equilateral Triangle":
                System.out.print("Enter side: ");
                side = sc.nextDouble();
                System.out.print("Enter color: ");
                sc.nextLine();
                color = sc.nextLine();
                shape = new EquilateralTriangle(side, color);
                shapes.add(shape); 
                break;
            case "CheckSquare":
                Shape s = new Square(0, "");
                if (s instanceof Rectangle) {
                    System.out.println("Square is a Rectangle");
                }
                return;
            case "CheckCircle":
                Shape cir = new Circle(0, "");
                if (cir instanceof Ellipse) {
                    System.out.println("Circle is an Ellipse");
                }
                return;
            case "CheckEquilateralTriangle":
                Shape et = new EquilateralTriangle(0, "");
                if (et instanceof Triangle) {
                    System.out.println("Equilateral Triangle is a Triangle");
                }
                return;

        }
        } while (!option.equals("DONE"));

        do {
            System.out.print("Sort by: ");
            option = sc.nextLine();
            switch (option) {
                case "DONE":
                    break;
                case "Color":
                    // TODO sort by color
                    Collections.sort(shapes);
                    for (Shape s : shapes) {
                        System.out.print("Area of " + s + ": ");
                        System.out.format("%.2f\n", s.area());
                    }
                    break;
                case "Area":
                    // TODO sort by area
                    shapes.sort(new Shape.AreaComparator());
                    for (Shape s : shapes) {
                        System.out.print("Area of " + s + ": ");
                        System.out.format("%.2f\n", s.area());
                    }
                    break;
                case "Perimeter":
                    // TODO sort by perimeter
                    shapes.sort(new Shape.PerimComparator());
                    for (Shape s : shapes) {
                        System.out.print("Perimeter of " + s + ": ");
                        System.out.format("%.2f\n", s.perimeter());
                    }
                    break;
            }
        } while (!option.equals("DONE"));
        sc.close();
    }
}
