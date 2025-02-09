package dk.capworld.typesoftriangles;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.Set;

public class TriangleCalculator {

    public TriangleCalculator() {
    };

    public void determinTriangleType() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Double[] triangleSideLengths;

        System.out.println("Determine triangle type");

        do {
            triangleSideLengths = getTriangleSideLengths();

            if (triangleSideLengths != null) {
                validateTriangleType(triangleSideLengths);
            }
        } while (triangleSideLengths != null);
    }


    private Double[] getTriangleSideLengths() {
        Double[] triangleSideLengths = new Double[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter " + (i + 1) + ". side of the triangle (q to quit): ");
            String input = scanner.nextLine();
            if (endInput(input.trim())) {
                return null;
            }
            if (!input.trim().isEmpty()) {
                try {
                    triangleSideLengths[i] = Double.valueOf(input.trim());
                    if (triangleSideLengths[i] < 0.0) {
                        System.out.print("Negative numbers not allowed. ");
                        i--;
                    }
                } catch (NumberFormatException ex) {
                    System.out.print("Invalid input. ");
                    i--;
                }
            } else {
                i--;
            }
        }
        return triangleSideLengths;
    }

    private Boolean endInput(String inputLine) {
        return ("q".equalsIgnoreCase(inputLine) || "quit".equalsIgnoreCase(inputLine));
    }

    private void validateTriangleType(Double[] triangleSideLengths) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections reflections = new Reflections("dk.capworld.typesoftriangles");
        Set<Class<? extends Triangle>> classes = reflections.getSubTypesOf(Triangle.class);
        Boolean validTriangleLengths = false;
        for (Class<?> thisclass : classes) {
            Triangle t = (Triangle) thisclass.getConstructor().newInstance();
            t.setSideLength(triangleSideLengths);
            if (!validTriangleLengths) {
                validTriangleLengths = t.validTriangleSideLengths(triangleSideLengths);  // Will only be tested for first implementation which is valid for all triangles
                if (!validTriangleLengths) {
                    System.out.println("Entered parameters for triangle are invalid.");
                    return;
                }
            }
            if (t.isThisType()) {
                System.out.println("This triangle is of type : " + t.getName() + " with area: " + t.getArea());
            }
        }
    }
}
