package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.model.Canvas;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class ColourFillMarker {

    public void fill(int x, int y, char colour, Canvas canvas) {

        floodFill(x,y,colour,canvas);
    }

    private void floodFill(int x, int y, char colour, Canvas canvas) {
        if(canvas.isMarked(x,y)){
            return;
        }
        canvas.mark(x,y,colour);

        fillNorth(x,y,colour, canvas);
        fillSouth(x,y,colour, canvas);
        fillEast(x,y,colour,canvas);
        fillWest(x,y,colour, canvas);
    }

    private void fillWest(int x, int y, char colour, Canvas canvas) {

        int x1 = x-1;
        if(!canvas.isWithinCanvas(x1,y)){
            return;
        }
        floodFill(x1,y,colour,canvas);
    }



    private void fillEast(int x, int y, char colour, Canvas canvas) {
        int x1 = x+1;
        if(!canvas.isWithinCanvas(x1,y)){
            return;
        }
        floodFill(x1,y,colour,canvas);
    }

    private void fillSouth(int x, int y, char colour, Canvas canvas) {
        int y1 = y+1;
        if(!canvas.isWithinCanvas(x,y1)){
            return;
        }
        floodFill(x,y1,colour,canvas);
    }

    private void fillNorth(int x, int y, char colour, Canvas canvas) {
        int y1 = y-1;
        if(!canvas.isWithinCanvas(x,y1)){
            return;
        }
        floodFill(x,y1,colour,canvas);
    }
}
