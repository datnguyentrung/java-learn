package J04;

import java.util.Scanner;

public class J04019 {
    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point(){}

        public Point(Point p){
            this.x = p.x;
            this.y = p.y;
        }

        public double distance(Point secondPoint){
            return Math.sqrt(Math.pow(this.x - secondPoint.x, 2) + Math.pow(this.y - secondPoint.y, 2));
        }

        public double distance(Point p1, Point p2){
            return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        }

        public static Point nextPoint(Scanner sc){
            return new Point (sc.nextDouble(), sc.nextDouble());
        }
    }

    static class Triangle{
        Point a, b, c;
        double n1, n2, n3, cv;

        public Triangle(Point a, Point b, Point c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public boolean valid() {
            this.n1 = a.distance(b);
            this.n2 = b.distance(c);
            this.n3 = c.distance(a);

            this.cv = n1 + n2 + n3;
            return (cv/2 - n1)*(cv/2 - n2)*(cv/2 - n3) > 0;
        }

        public String getPerimeter() {
            return String.format("%.3f", cv);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}
