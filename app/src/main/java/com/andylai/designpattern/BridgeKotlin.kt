package com.andylai.designpattern

class BridgeKotlin {

    fun main() {
        val circle = Circle(Drawing2(), 0, 0, 5)
        circle.draw()
        val rect = Rectangle(Drawing1(), 0, 0, 5, 5)
        rect.draw()
    }

    abstract class Shape(private val drawing: Drawing) {

        fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int) {
            drawing.drawLine(x1, y1, x2, y2)
        }

        fun drawCircle(x1: Int, y1: Int, r: Int) {
            drawing.drawCircle(x1, y1, r)
        }

        abstract fun draw()
    }

    class Rectangle(drawing: Drawing,
                    private val x1: Int,
                    private val y1: Int,
                    private val x2: Int,
                    private val y2: Int) : Shape(drawing) {
        override fun draw() {
            drawLine(x1, y1, x2, y2)
        }
    }

    class Circle(drawing: Drawing,
                 private val x1: Int,
                 private val y1: Int,
                 private val r: Int) : Shape(drawing) {
        override fun draw() {
            drawCircle(x1, y1, r)
        }

    }

    class Drawing2 : Drawing() {
        override fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int) {
            DP2.drawLine(x1, y1, x2, y2)
        }

        override fun drawCircle(x1: Int, y1: Int, r: Int) {
            DP2.drawCircle(x1, y1, r)
        }
    }

    class Drawing1 : Drawing() {
        override fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int) {
            DP1.draw_a_line(x1, y1, x2, y2)
        }

        override fun drawCircle(x1: Int, y1: Int, r: Int) {
            DP1.draw_a_circle(x1, y1, r)
        }
    }

    abstract class Drawing {
        abstract fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int)
        abstract fun drawCircle(x1: Int, y1: Int, r: Int)
    }

    class DP1 {
        companion object {
            fun draw_a_line(x1: Int, y1: Int, x2: Int, y2: Int) {}
            fun draw_a_circle(x1: Int, y1: Int, r: Int) {}
        }
    }

    class DP2 {
        companion object {
            fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int) {}
            fun drawCircle(x1: Int, y1: Int, r: Int) {}
        }
    }
}