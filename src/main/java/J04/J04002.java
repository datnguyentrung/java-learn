package J04;

import java.util.Scanner;

public class J04002 {
    static class Rectange {
        double width, height;
        String color;

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Rectange(double width, double height, String color) {
            this.width = width;
            this.height = height;
            this.color = Character.toUpperCase(color.charAt(0)) + color.substring(1).toLowerCase();
        }

        public int findArea(){
            return (int) (this.height * this.width);
        }

        public int findPerimeter(){
            return (int) (this.height + this.width) * 2;
        }

        @Override
        public String toString(){
            return findPerimeter() + " " + findArea() + " " + this.color;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble(), b = sc.nextDouble();

        if (a <= 0 || b <= 0) {
            System.out.println("INVALID");
            return;
        }

        Rectange rectange = new Rectange(
                a, b, sc.next()
        );

        System.out.println(rectange);
    }
}
