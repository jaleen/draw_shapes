package com.jalalsoft.shapes.validator;

import com.jalalsoft.shapes.model.Canvas;
import com.jalalsoft.shapes.model.Line;

/**
 * Created by jalal.deen on 12/04/2017.
 */
public class LineValidator {
    public boolean validate(Line line, Canvas canvas) {
        if(line.getX1()<1|| line.getX1()>canvas.getWidth()-2){
            throw new IllegalArgumentException("x1 is out of bounds of canvas.");
        }else if(line.getX2()<1|| line.getX2()>canvas.getWidth()-2){
            throw new IllegalArgumentException("x2 is out of bounds of canvas.");
        }
        return true;
    }
}
