package dk.capworld.typesoftriangles.impl;

import dk.capworld.typesoftriangles.Triangle;

public class Scalene implements Triangle {

    private Double[] sideLenght;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Boolean isThisType() {
        if (sideLenght.length == 0) {
            return false;
        }
        return (!sideLenght[0].equals(sideLenght[1])
                && !sideLenght[1].equals(sideLenght[2])
                && !sideLenght[2].equals(sideLenght[0]));
    }

    @Override
    public void setSideLength(Double[] sideLength) {
        this.sideLenght = sideLength;
    }

    @Override
    public Double[] getSideLength() {
        return this.sideLenght;
    }

    @Override
    public Double getArea() {
        return isocelesArea(sideLenght[0], sideLenght[1], sideLenght[2]);
    }

    private Double isocelesArea(Double a, Double b, Double c) {
        Double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
