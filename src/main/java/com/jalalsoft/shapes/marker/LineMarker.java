package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;

/**
 * Created by jalal.deen on 04/04/2017.
 */
public class LineMarker {


    public void mark(Line line, Canvas canvas, char lineChar) {


        int width = line.getX2() - line.getX1() + 1;
        int height = line.getY2() - line.getY1() + 1;

        if (width > height) {
            markHorizontalLine(line, canvas, lineChar);
        } else {
            markVerticalLine(line, canvas, lineChar);
        }
    }

    private void markVerticalLine(Line line, Canvas canvas, char lineChar) {
        for (int count = line.getY1(); count <= line.getY2(); count++) {
            canvas.mark(line.getX1(), count, lineChar);
        }
    }

    private void markHorizontalLine(Line line, Canvas canvas, char lineChar) {
        for (int count = line.getX1(); count <= line.getX2(); count++) {
            canvas.mark(count, line.getY1(), lineChar);
        }
    }

}
