package com.jalalsoft.shapes.validator;

import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Rectangle;
import org.junit.Test;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class RectangleValidatorTest {

    @Test
    public void whenRectangleCoordinatesValid_thenValidationSuccessful(){

        RectangleValidator rectangleValidator = new RectangleValidator();
        Rectangle rectangle = new Rectangle(2,2,6,6);
        Canvas canvas = new Canvas(7,7);
        boolean valid = rectangleValidator.validate(rectangle,canvas);

    }
    @Test (expected = IllegalArgumentException.class)
    public void whenRectangleCoordinatesOutSideCanvas_thenValidationShouldFail(){

        RectangleValidator rectangleValidator = new RectangleValidator();
        Rectangle rectangle = new Rectangle(-1,2,6,6);
        Canvas canvas = new Canvas(7,7);
        rectangleValidator.validate(rectangle,canvas);

    }
}
