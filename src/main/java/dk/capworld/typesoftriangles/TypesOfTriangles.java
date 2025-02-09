package dk.capworld.typesoftriangles;

import dk.capworld.typesoftriangles.exception.TypesOfTrianglesException;

import java.lang.reflect.InvocationTargetException;

public class TypesOfTriangles {
    public static void main(String[] args) {
        try {
            new TriangleCalculator().determinTriangleType();
            System.out.println("End program.");
        } catch (TypesOfTrianglesException ex) {
            System.out.println("Error occurred: " + ex.getMessage());
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Exception occurred: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
