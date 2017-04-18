package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import com.jalalsoft.shapes.model.Rectangle;
import com.jalalsoft.shapes.validator.RectangleValidator;


public class RectangleMarker extends LineMarker{
    private final char lineChar;

    public RectangleMarker(RectangleValidator recValidator, char lineChar) {
        super(recValidator, lineChar);
        this.lineChar = lineChar;
    }
    public void mark(Rectangle rectangle, Canvas canvas) {
        markTopLine(rectangle, canvas);
        markBottomLine(rectangle, canvas);
        markLeftLine(rectangle, canvas);
        markRightLine(rectangle, canvas);
    }

    private void markRightLine(Rectangle rectangle, Canvas canvas) {

        Line line = new Line(rectangle.getX2(), rectangle.getY1(), rectangle.getX2(), rectangle.getY2());
        mark(line, canvas, lineChar);
    }

    private void markLeftLine(Rectangle rectangle, Canvas canvas) {

        Line line = new Line(rectangle.getX1(), rectangle.getY1(), rectangle.getX1(), rectangle.getY2());
        mark(line, canvas, lineChar);
    }

    private void markBottomLine(Rectangle rectangle, Canvas canvas) {
        Line line = new Line(rectangle.getX1(), rectangle.getY2(), rectangle.getX2(), rectangle.getY2());
        mark(line, canvas, lineChar);

    }

    private void markTopLine(Rectangle rectangle, Canvas canvas) {
        Line line = new Line(rectangle.getX1(), rectangle.getY1(), rectangle.getX2(), rectangle.getY1());
        mark(line, canvas, lineChar);
    }
}
