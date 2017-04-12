package com.jalalsoft.shapes.model;

/**
 * Created by jalal.deen on 12/04/2017.
 */
public class Canvas {

    private char[][] canvas;

    public Canvas(int width, int height) {

        //added two (+2) more spaces for boundary lines.
        canvas = new char[height + 2][width + 2];
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
}

