package com.capworld.typesoftriangles.impl;

import dk.capworld.typesoftriangles.impl.Isosceles;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IsocelesTest {


    private Isosceles isosceles;

    @Before
    public void init() {
        isosceles = new Isosceles();
    }

    @Test
    public void validateTriangleLengthsOKTest() {
        Double[] sideLengths = new Double[]{14.0, 14.0, 12.0};
        assertTrue(this.isosceles.validTriangleSideLengths(sideLengths));
    }

    @Test
    public void validateTriangleLengthsNOKTest() {
        Double[] sideLengths = new Double[]{13.0, 1.0, 17.0};
        assertFalse(this.isosceles.validTriangleSideLengths(sideLengths));
        ;
    }

    @Test
    public void getNameTest() {
        assertEquals("Isosceles", this.isosceles.getName());
    }

    @Test
    public void isThisTypeOKTest() {
        Double[] sideLengths = new Double[]{13.0, 13.0, 12.0};
        this.isosceles.setSideLength(sideLengths);
        assertTrue(this.isosceles.isThisType());
    }

    @Test
    public void isThisTypeNOKTest() {
        Double[] sideLengths = new Double[]{13.0, 1.0, 17.0};
        this.isosceles.setSideLength(sideLengths);
        assertFalse(this.isosceles.isThisType());
    }

    @Test
    public void isThisTypeOK3sidesEqualTest() {
        Double[] sideLengths = new Double[]{13.0, 13.0, 13.0};
        this.isosceles.setSideLength(sideLengths);
        assertTrue(this.isosceles.isThisType());
    }

    @Test
    public void setTriangleLengths() {
        Double[] sideLengths = new Double[]{13.0, 13.0, 17.0};
        this.isosceles.setSideLength(sideLengths);
        assertEquals(sideLengths[0], this.isosceles.getSideLength()[0]);
        assertEquals(sideLengths[1], this.isosceles.getSideLength()[1]);
        assertEquals(sideLengths[2], this.isosceles.getSideLength()[2]);
    }

    @Test
    public void AreaTest() {
        Double[] sideLengths = new Double[]{13.0, 13.0, 17.0};
        this.isosceles.setSideLength(sideLengths);
        Double area = this.isosceles.getArea();
        assertEquals(83.6073411848505, area, 0.0001);
    }

}
