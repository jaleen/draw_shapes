package com.jalalsoft.shapes.validator;

import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by jalal.deen on 12/04/2017.
 */
public class LineValidatorTest {
    LineValidator lineValidator = null;

    @Before
    public void setup() {
        lineValidator = new LineValidator();
    }

    @Test
    public void whenValidCoordinate_thenValidationSuccessful() {

        Line line = new Line(3, 2, 5, 2);

        int width = 6;
        int height = 5;
        Canvas canvas = null;
        canvas = new Canvas(width, height);

        boolean valid = lineValidator.validate(line, canvas);

        assertTrue("For valid coordinates validation should be successful", valid);
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenX1CoordinateAreGreaterThanCanvas_thenThrowException() {

        int x1 = 6;
        Line line = new Line(x1, 1, 1, 1);

        int width = 5;
        int height = 5;
        Canvas canvas = null;
        canvas = new Canvas(width, height);

        lineValidator.validate(line, canvas);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenX2CoordinateAreGreaterThanCanvas_thenThrowException() {

        int x2 = 6;
        Line line = new Line(1, 1, x2, 1);

        int width = 5;
        int height = 5;
        Canvas canvas = null;
        canvas = new Canvas(width, height);

        lineValidator.validate(line, canvas);
    }

}
