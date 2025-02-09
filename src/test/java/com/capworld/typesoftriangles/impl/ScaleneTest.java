package com.capworld.typesoftriangles.impl;

import dk.capworld.typesoftriangles.impl.Scalene;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScaleneTest {


    private Scalene scalene;

    @Before
    public void init() {
        scalene = new Scalene();
    }

    @Test
    public void validateTriangleLengthsOKTest() {
        Double[] sideLengths = new Double[]{13.0, 14.0, 12.0};
        assertTrue(this.scalene.validTriangleSideLengths(sideLengths));
    }

    @Test
    public void validateTriangleLengthsNOKTest() {
        Double[] sideLengths = new Double[]{13.0, 1.0, 17.0};
        assertFalse(this.scalene.validTriangleSideLengths(sideLengths));
        ;
    }

    @Test
    public void getNameTest() {
        assertEquals("Scalene", this.scalene.getName());
    }

    @Test
    public void isThisTypeOKTest() {
        Double[] sideLengths = new Double[]{11.0, 13.0, 12.0};
        this.scalene.setSideLength(sideLengths);
        assertTrue(this.scalene.isThisType());
    }

    @Test
    public void isThisTypeNOKTest() {
        Double[] sideLengths = new Double[]{13.0, 13.0, 17.0};
        this.scalene.setSideLength(sideLengths);
        assertFalse(this.scalene.isThisType());
    }

    @Test
    public void isThisTypeNOK3sidesEqualTest() {
        Double[] sideLengths = new Double[]{13.0, 13.0, 13.0};
        this.scalene.setSideLength(sideLengths);
        assertFalse(this.scalene.isThisType());
    }

    @Test
    public void setTriangleLengths() {
        Double[] sideLengths = new Double[]{13.0, 14.0, 17.0};
        this.scalene.setSideLength(sideLengths);
        assertEquals(sideLengths[0], this.scalene.getSideLength()[0]);
        assertEquals(sideLengths[1], this.scalene.getSideLength()[1]);
        assertEquals(sideLengths[2], this.scalene.getSideLength()[2]);
    }

    @Test
    public void AreaTest() {
        Double[] sideLengths = new Double[]{13.0, 14.0, 17.0};
        this.scalene.setSideLength(sideLengths);
        Double area = this.scalene.getArea();
        assertEquals(88.99438184514796, area, 0.0001);
    }
}