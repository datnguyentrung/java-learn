package J05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J05008 {
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
            int n = sc.nextInt();
            List<Point> points = new ArrayList<>();

            for (int i = 0; i < n; i++){
                points.add(new Point(
                        sc.nextInt(), sc.nextInt()
                ));
            }

            double sum = 0;
            for (int i = 0; i < n; i++){
                Point a = points.get(i);
                Point b = points.get((i + 1) % n);

                sum += a.getX() * b.getY() - b.getX() * a.getY();
            }
            System.out.printf("%.3f\n", sum/2);
        }
    }
}
