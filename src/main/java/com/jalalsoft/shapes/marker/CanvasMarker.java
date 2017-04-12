package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import com.jalalsoft.shapes.validator.LineValidator;

/**
 * Created by jalal.deen on 12/04/2017.
 */
public class CanvasMarker extends LineMarker {
    private final char horizontalChar;
    private final char verticalChar;

    public CanvasMarker(char horizontalChar, char verticalChar) {

        this.horizontalChar = horizontalChar;
        this.verticalChar = verticalChar;
    }

    public void markBoundary(Canvas canvas) {

        markTopBoundaryLine(canvas);
        markBottomBoundaryLine(canvas);
        markLeftBoundaryLine(canvas);
        markRightBoundaryLine(canvas);
    }

    private void markRightBoundaryLine(Canvas canvas) {

        Line line = new Line(canvas.getWidth() - 1, 1, canvas.getWidth() - 1, canvas.getHeight() - 2);
        mark(line, canvas, verticalChar);
    }

    private void markLeftBoundaryLine(Canvas canvas) {
        Line line = new Line(0, 1, 0, canvas.getHeight() - 2);
        mark(line, canvas, verticalChar);


    }

    private void markBottomBoundaryLine(Canvas canvas) {
        Line line = new Line(0, canvas.getHeight() - 1, canvas.getWidth()-1, canvas.getHeight() - 1);
        mark(line, canvas, horizontalChar);

    }

    private void markTopBoundaryLine(Canvas canvas) {
        Line line = new Line(0, 0, canvas.getWidth() - 1, 0);
        mark(line, canvas, horizontalChar);
    }
}
