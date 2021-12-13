package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public class Rectangle extends Node {
    private Double fromx;
    private Double fromy;
    private Double tox;
    private Double toy;
    private Double length;
    private Double width;
    private Color insidecolor;
    private Color outsideclor;

    public Double getFromx(double value) {
        return fromx;
    }

    public void setFromx(Double fromx) {
        this.fromx = fromx;
    }

    public Double getFromy(double value) {
        return fromy;
    }

    public void setFromy(Double fromy) {
        this.fromy = fromy;
    }

    public Double getTox(double value) {
        return tox;
    }

    public void setTox(Double tox) {
        this.tox = tox;
    }

    public Double getToy(double value) {
        return toy;
    }

    public void setToy(Double toy) {
        this.toy = toy;
    }

    public Double getLength(double value) {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth(double value) {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Color getInsidecolor() {
        return insidecolor;
    }

    public void setInsidecolor(Color insidecolor) {
        this.insidecolor = insidecolor;
    }

    public Color getOutsideclor() {
        return outsideclor;
    }

    public void setOutsideclor(Color outsideclor) {
        this.outsideclor = outsideclor;
    }

    public Rectangle(Double fromx, Double fromy, Double tox, Double toy, Double length, Double width, Color insidecolor, Color outsideclor) {
        this.fromx = fromx;
        this.fromy = fromy;
        this.tox = tox;
        this.toy = toy;
        this.length = length;
        this.width = width;
        this.insidecolor = insidecolor;
        this.outsideclor = outsideclor;
    }

    @Override
    public Node getStyleableNode() {
        return null;
    }
}
