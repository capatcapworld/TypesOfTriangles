package com.capworld.typesoftriangles.impl;

import dk.capworld.typesoftriangles.impl.Equilateral;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EquilateralTest {

    private Equilateral equilateral;

    @Before
    public void init() {
            this.equilateral = new Equilateral();
        }

    @Test
    public void validateTriangleLengthsOKTest() {
        Double[] sideLengths = new Double[] {14.0, 14.0 ,14.0 };
        assertTrue(this.equilateral.validTriangleSideLengths(sideLengths));;
    }

    @Test
    public void validateTriangleLengthsNOKTest() {
        Double[] sideLengths = new Double[] {13.0, 1.0 ,17.0 };
        assertFalse(this.equilateral.validTriangleSideLengths(sideLengths));;
    }

    @Test
    public void getNameTest() {
        Double[] sideLengths = new Double[] {13.0, 13.0 ,13.0 };
        this.equilateral.setSideLength(sideLengths);
        assertEquals("Equilateral", this.equilateral.getName());;
    }


    @Test
    public void isThisTypeOKTest() {
        Double[] sideLengths = new Double[] {13.0, 13.0 ,13.0 };
        this.equilateral.setSideLength(sideLengths);
        assertTrue(this.equilateral.isThisType());;
    }

    @Test
    public void isThisTypeNOKTest() {
        Double[] sideLengths = new Double[] {13.0, 1.0 ,17.0 };
        this.equilateral.setSideLength(sideLengths);
        assertFalse(this.equilateral.isThisType());;
    }

    @Test
    public void setTriangleLengths() {
        Double[] sideLengths = new Double[] {13.0, 1.0 ,17.0 };
        this.equilateral.setSideLength(sideLengths);
        assertEquals(sideLengths[0],  this.equilateral.getSideLength()[0]);
        assertEquals(sideLengths[1],  this.equilateral.getSideLength()[1]);
        assertEquals(sideLengths[2],  this.equilateral.getSideLength()[2]);
    }

    @Test
    public void AreaTest() {
        Double[] sideLengths = new Double[] {13.0, 13.0 ,13.0 };
        this.equilateral.setSideLength(sideLengths);
        Double area = this.equilateral.getArea();
        assertEquals(73.17914661978506, area, 0.0001);
    }

}
