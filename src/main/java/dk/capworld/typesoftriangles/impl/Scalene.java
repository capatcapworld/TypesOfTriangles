package dk.capworld.typesoftriangles.impl;

import dk.capworld.typesoftriangles.Triangle;

public class Scalene implements Triangle {

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
        return (!sideLength[0].equals(sideLength[1])
                && !sideLength[1].equals(sideLength[2])
                && !sideLength[2].equals(sideLength[0]));
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
        return isocelesArea(sideLength[0], sideLength[1], sideLength[2]);
    }

    private Double isocelesArea(Double a, Double b, Double c) {
        Double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
