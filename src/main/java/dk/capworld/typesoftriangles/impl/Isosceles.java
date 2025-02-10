package dk.capworld.typesoftriangles.impl;

import dk.capworld.typesoftriangles.Triangle;

public class Isosceles implements Triangle {

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
        return (sideLength[0].equals(sideLength[1]) ||
                sideLength[0].equals(sideLength[2]) ||
                sideLength[1].equals(sideLength[2]) );
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
        if (sideLength[0].equals(sideLength[1])) {
           return isocelesArea(sideLength[0], sideLength[2]);
        } else
        if (sideLength[0].equals(sideLength[2])) {
            return isocelesArea(sideLength[0], sideLength[1]);
        } else
        if (sideLength[1].equals(sideLength[2])) {
            return isocelesArea(sideLength[1], sideLength[0]);
        }
        return null;
    }

    private Double isocelesArea(Double a, Double b) {
        Double h_b = Math.sqrt(a * a - (b/2) * (b/2));
        return (b * h_b) / 2;
    }
}
