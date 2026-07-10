package J04;

import java.util.Scanner;

public class J04001 {
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
            Point a = new Point(
                    sc.nextDouble(),
                    sc.nextDouble()
            );

            Point b = new Point(
                    sc.nextDouble(),
                    sc.nextDouble()
            );

            System.out.printf("%.4f\n", a.distance(b));
        }
    }
}
