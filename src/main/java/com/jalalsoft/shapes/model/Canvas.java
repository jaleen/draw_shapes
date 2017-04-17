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
        clean();
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

        if(currentCanvas==null){
            throw new IllegalArgumentException("Create a canvas first using command c width height e.g. c 5 6");
        }
        return currentCanvas;
    }

    public boolean isMarked(int x, int y) {

        char mark = canvas[y][x];
        if(Character.MIN_VALUE ==  mark) {
            return false;
        }else{
            return true;
        }
    }

    public boolean isWithinCanvas(int x, int y) {

        if(x<1|| x>getWidth()-2){
           return false;
        }else if(y<1|| y>getHeight()-2){
            return false;
        }
        return true;
    }
    public static void clean(){
        currentCanvas = null;
    }
}

