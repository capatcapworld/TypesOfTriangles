package dk.capworld.typesoftriangles.impl;

import dk.capworld.typesoftriangles.Triangle;

public class Isosceles implements Triangle {

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
        return (sideLenght[0].equals(sideLenght[1]) ||
                sideLenght[0].equals(sideLenght[2]) ||
                sideLenght[1].equals(sideLenght[2]) );
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
        if (sideLenght[0].equals(sideLenght[1])) {
           return isocelesArea(sideLenght[0], sideLenght[2]);
        } else
        if (sideLenght[0].equals(sideLenght[2])) {
            return isocelesArea(sideLenght[0], sideLenght[1]);
        } else
        if (sideLenght[1].equals(sideLenght[2])) {
            return isocelesArea(sideLenght[1], sideLenght[0]);
        }
        return null;
    }

    private Double isocelesArea(Double a, Double b) {
        Double h_b = Math.sqrt(a * a - (b/2) * (b/2));
        return (b * h_b) / 2;
    }
}
