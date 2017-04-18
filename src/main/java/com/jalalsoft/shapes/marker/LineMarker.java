package com.jalalsoft.shapes.marker;

import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import com.jalalsoft.shapes.validator.LineValidator;

/**
 * Created by jalal.deen on 04/04/2017.
 */
public class LineMarker {

    private final char lineChar;
    private final LineValidator lineValidator;

    public LineMarker(LineValidator lineValidator, char lineChar) {
        this.lineValidator = lineValidator;
        this.lineChar = lineChar;
    }

    public LineMarker(LineValidator lineValidator) {
        this.lineValidator = lineValidator;
        this.lineChar = 'x';
    }

    public void mark(Line line, Canvas canvas) {
        mark(line, canvas, lineChar);
    }

    public void mark(Line line, Canvas canvas, char lineChar) {

        if (lineValidator != null)
            lineValidator.validate(line, canvas);

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
