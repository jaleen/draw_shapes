package com.jalalsoft.shapes.validator;

import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;
import com.jalalsoft.shapes.model.Rectangle;

/**
 * Created by jalal.deen on 17/04/2017.
 */
public class RectangleValidator extends LineValidator{

    public boolean validate(Rectangle rec, Canvas canvas){

        Line diagonal = new Line(rec.getX1(),rec.getY1(),rec.getX2(),rec.getY2());
        super.validate(diagonal,canvas);
        return true;
    }
}
