package dk.capworld.typesoftriangles;

public interface Triangle {

    /**
     * Validate whether this triangle has side lengths which are valid.
     *
     * @param triangleSideLengths The triangle side lengths
     * @return true if the triangle has valid lengths else false
     */
    default Boolean validTriangleSideLengths(Double[] triangleSideLengths) {
        return ((triangleSideLengths[0] + triangleSideLengths[1] > triangleSideLengths[2]) &&
                (triangleSideLengths[0] + triangleSideLengths[2] > triangleSideLengths[1]) &&
                (triangleSideLengths[1] + triangleSideLengths[2] > triangleSideLengths[0]));
    }

    /**
     * This should return the name of the triangle.
     *
     * @return The triangle name
     */
    String getName();

    /**
     * Is the triangle of this specific type.
     *
     * @return True if has this type else false.
     */
    Boolean isThisType();

    /**
     * Set the side lengths of the triangle
     *
     * @param sideLength  The triangle side lengths
     */
    void setSideLength(Double[] sideLength);

    /**
     * Return the side lengths of this triangle
     *
     * @return The side lengths set for this triangle.
     */
    Double[] getSideLength();

    /**
     * The area of this triangle.
     *
     * @return The area of this triangle.
     */
    Double getArea();
}
