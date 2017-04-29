package com.example.den.herome.model;

/**
 * Created by den on 2017-04-25.
 */

public class ViewData {
    private int drawableLeft;
    private String name;
    private int drawableRight;

    public ViewData(int drawableLeft, String name, int drawableRight) {
        this.drawableLeft = drawableLeft;
        this.name = name;
        this.drawableRight = drawableRight;
    }

    public int getDrawableLeft() {
        return drawableLeft;
    }

    public String getName() {
        return name;
    }

    public int getDrawableRight() {
        return drawableRight;
    }
}
