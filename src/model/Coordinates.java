package model;

/**
 * Представляет координаты человека на плоскости.
 */
public class Coordinates {
    private Integer x;
    private Double y;

    /**
     * @param x координата X, не может быть null, максимум 300
     * @param y координата Y, не может быть null, должна быть больше -153
     */
    public Coordinates(Integer x, Double y) {
        setX(x);
        setY(y);
    }

    /**
     * @param x координата X
     * @throws IllegalArgumentException если x равен null или больше 300
     */
    public void setX(Integer x) {
        if (x == null) throw new IllegalArgumentException("X не может быть null");
        if (x > 300) throw new IllegalArgumentException("X не может быть больше 300");
        this.x = x;
    }

    /**
     * @param y координата Y
     * @throws IllegalArgumentException если y равен null или меньше/равен -153
     */
    public void setY(Double y) {
        if (y == null) throw new IllegalArgumentException("Y не может быть null");
        if (y <= -153) throw new IllegalArgumentException("Y должен быть больше -153");
        this.y = y;
    }

    /** @return координата X */
    public Integer getX() { return x; }

    /** @return координата Y */
    public Double getY() { return y; }

    @Override
    public String toString() {
        return "Coordinates{x=" + x + ", y=" + y + "}";
    }
}