package sample;

import javafx.scene.paint.Color;

 public class Rectangle {
 private String name;
 private Color insidecolor;
 private Color outsideclor;
 private Double length;
 private Double width;
 private Double x;
 private Double y;

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public Color getInsidecolor() {
        return insidecolor;
    }

    public void setInsidecolor(Color insidecolor) {
        this.insidecolor = insidecolor;
    }

    public Color getoutsideclor() {
        return outsideclor;
    }

    public void setOoutsideclor(Color outsideclor) {
        this.outsideclor = outsideclor;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }



     @Override
     public String toString() {
         return "Rectangle{" +
                 "name='" + name + '\'' +
                 ", insidecolor=" + insidecolor +
                 ", outsideclor='" + outsideclor + '\'' +
                 ", length=" + length +
                 ", width=" + width +
                 ", x=" + x +
                 ", y=" + y +
                 '}';
     }

     public Rectangle(Double x, Double y) {
         this.x = x;
         this.y = y;
     }
 }
