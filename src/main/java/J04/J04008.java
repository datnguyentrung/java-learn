package J04;

import java.util.Scanner;

public class J04008 {
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

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double distance(Point secondPoint){
            return Math.sqrt(Math.pow(this.x - secondPoint.x, 2) + Math.pow(this.y - secondPoint.y, 2));
        }

        public double distance(Point p1, Point p2){
            return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0){
            Point a = new Point(sc.nextDouble(), sc.nextDouble());
            Point b = new Point(sc.nextDouble(), sc.nextDouble());
            Point c = new Point(sc.nextDouble(), sc.nextDouble());

            double c1 = a.distance(b);
            double c2 = b.distance(c);
            double c3 = c.distance(a);

            if (c1 + c2 <= c3 || c1 + c3 <= c2 || c2 + c3 <= c1){
                System.out.println("INVALID");
            } else {
                System.out.printf("%.3f\n", c1+c2+c3);
            }
        }
    }
}
