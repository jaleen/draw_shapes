package com.jalalsoft.shapes.model;

/**
 * Created by jalal.deen on 12/04/2017.
 */
public class Canvas {

    private char[][] canvas;
    private static Canvas currentCanvas;

    public Canvas(int width, int height) {
        if (width < 1) {
            throw new IllegalArgumentException("Invalid canvas width:" + width + " It should always be more than 1.");
        }
        if (height < 1) {
            throw new IllegalArgumentException("Invalid canvas height:" + height + " It should always be more than 1.");

        }

        //added two (+2) more spaces for boundary lines.
        canvas = new char[height + 2][width + 2];
        currentCanvas = this;
    }

    public void mark(int x, int y, char lineChar) {

        canvas[y][x] = lineChar;
    }

    @Override
    public String toString() {

        String lines = "";
        for (char[] line : canvas) {
            for (char pixel : line) {
                if (Character.MIN_VALUE == pixel) {
                    lines += ' ';
                } else {

                    lines += pixel;
                }

            }
            lines += '\n';
        }
        return lines;
    }
    public int getWidth() {
        return canvas[0].length;
    }

    public int getHeight() {
        return canvas.length;
    }
    public static Canvas getCurrentCanvas(){

        return currentCanvas;
    }
}

