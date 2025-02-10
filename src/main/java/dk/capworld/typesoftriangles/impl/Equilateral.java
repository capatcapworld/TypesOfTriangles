package dk.capworld.typesoftriangles.impl;

import dk.capworld.typesoftriangles.Triangle;

public class Equilateral implements Triangle {

    private Double[] sideLength;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Boolean isThisType() {
        if (sideLength.length == 0) {
            return false;
        }
        return (sideLength[0].equals(sideLength[1]) && sideLength[1].equals(sideLength[2]));
    }

    @Override
    public void setSideLength(Double[] sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public Double[] getSideLength() {
        return this.sideLength;
    }

    @Override
    public Double getArea() {
        return (Math.sqrt(3)/4.0) * this.sideLength[0] * this.sideLength[0];
    }
}
