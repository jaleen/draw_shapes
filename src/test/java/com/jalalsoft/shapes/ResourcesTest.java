package com.jalalsoft.shapes;

import com.jalalsoft.shapes.config.Configuration;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by jalal.deen on 13/04/2017.
 */
public class ResourcesTest {

    @Test
    public void givenProperties_thenShouldLoadCanvasHorizontalLineCharacters() throws IOException {

        Configuration configuration = Configuration.init("shapes-test.properties");

        String propertyName = "horizontalBoundaryCharacter";
        String actual = configuration.getPropertyValue(propertyName);
        String expected = "-";
        assertEquals("incorrect property attribute",expected,actual);

    }
    @Test
    public void givenProperties_thenShouldLoadCanvasVerticalLineCharacters() throws IOException {

        Configuration configuration = Configuration.init("shapes-test.properties");

        String propertyName = "verticalBoundaryCharacter";
        String actual = configuration.getPropertyValue(propertyName);
        String expected = "|";
        assertEquals("incorrect property attribute",expected,actual);


    }
}
