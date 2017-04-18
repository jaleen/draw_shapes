package com.jalalsoft.shapes.model;

/**
 * Created by jalal.deen on 12/04/2017.
 */
public class Canvas {

    private char[][] canvasMap;
    private static Canvas currentCanvas;

    private Canvas(int width, int height) {
        if (width < 1) {
            throw new IllegalArgumentException("Invalid canvas width:" + width + " It should always be more than 1.");
        }
        if (height < 1) {
            throw new IllegalArgumentException("Invalid canvas height:" + height + " It should always be more than 1.");

        }

        //added two (+2) more spaces for boundary lines.
        canvasMap = new char[height + 2][width + 2];


    }

    public static Canvas getInstance(int width, int height) {

        Canvas canvas = new Canvas(width, height);
        currentCanvas = canvas;
        return canvas;
    }

    public void mark(int x, int y, char lineChar) {

        canvasMap[y][x] = lineChar;
    }

    @Override
    public String toString() {

        StringBuilder lines = new StringBuilder("");
        for (char[] line : canvasMap) {
            for (char pixel : line) {
                if (Character.MIN_VALUE == pixel) {
                    lines.append(' ');
                } else {

                    lines.append(pixel);
                }

            }
            lines.append(System.lineSeparator());
        }
        return lines.toString();
    }

    public int getWidth() {
        return canvasMap[0].length;
    }

    public int getHeight() {
        return canvasMap.length;
    }

    public static Canvas getCurrentCanvas() {

        if (currentCanvas == null) {
            throw new IllegalArgumentException("Create a canvas first using command c width height e.g. c 5 6");
        }
        return currentCanvas;
    }

    public boolean isMarked(int x, int y) {

        char mark = canvasMap[y][x];
        if (Character.MIN_VALUE == mark) {
            return false;
        }
        return true;

    }

    public boolean isWithinCanvas(int x, int y) {

        if (x < 1 || x > getWidth() - 2) {
            return false;
        } else if (y < 1 || y > getHeight() - 2) {
            return false;
        }
        return true;
    }

    public static void clean() {
        currentCanvas = null;
    }
}

