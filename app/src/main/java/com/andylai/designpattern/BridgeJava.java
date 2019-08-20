package com.andylai.designpattern;

public class BridgeJava {

    void main() {
        Shape circle = new Circle(new Drawing2(), 0, 0, 5);
        circle.draw();

        Shape rect = new Rectangle(new Drawing1(), 0,0,5,5);
        rect.draw();
    }

    abstract class Shape {

        Drawing mDrawing;

        Shape(Drawing drawing) {
            mDrawing = drawing;
        }

        void drawLine(int x1, int y1, int x2, int y2) {
            mDrawing.drawLine(x1, y1, x2, y2);
        }

        void drawCircle(int x1, int y1, int radius) {
            mDrawing.drawCircle(x1, y1, radius);
        }

        abstract void draw();
    }

    public class Rectangle extends Shape {

        int x1, y1, x2, y2;

        Rectangle(Drawing drawing, int _x1, int _y1, int _x2, int _y2) {
            super(drawing);
            x1 = _x1;
            y1 = _y1;
            x2 = _x2;
            y2 = _y2;
        }

        @Override
        void draw() {
            drawLine(x1, y1, x2, y2);
        }
    }

    public class Circle extends Shape {
        int x1, y1, r;

        Circle(Drawing drawing, int x1, int y1, int r) {
            super(drawing);
            this.x1 = x1;
            this.y1 = y1;
            this.r = r;
        }

        @Override
        void draw() {
            drawCircle(x1, y1, r);
        }
    }

    abstract class Drawing {
        abstract void drawLine(int x1, int y1, int x2, int y2);

        abstract void drawCircle(int x1, int y1, int radius);
    }

    class Drawing1 extends Drawing {

        @Override
        void drawLine(int x1, int y1, int x2, int y2) {
            DP1.draw_a_line();
        }

        @Override
        void drawCircle(int x1, int y1, int radius) {
            DP1.draw_a_circle();
        }
    }

    class Drawing2 extends Drawing {

        @Override
        void drawLine(int x1, int y1, int x2, int y2) {
            DP2.drawLine();
        }

        @Override
        void drawCircle(int x1, int y1, int radius) {
            DP2.drawCircle();
        }
    }

    public static class DP1 {
        public static void draw_a_line() {
        }

        public static void draw_a_circle() {
        }
    }

    public static class DP2 {
        public static void drawLine() {
        }

        public static void drawCircle() {
        }
    }
}
