package dk.capworld.typesoftriangles.impl;

import dk.capworld.typesoftriangles.Triangle;

public class Equilateral implements Triangle {

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
        return (sideLenght[0].equals(sideLenght[1]) && sideLenght[1].equals(sideLenght[2]));
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
        return (Math.sqrt(3)/4.0) * this.sideLenght[0] * this.sideLenght[0];
    }
}
