package model;

public class Coordinates {
    private Integer x; // Макс: 300, Not null
    private Double y;  // Мин: -153, Not null

    public Coordinates(Integer x, Double y) {
        setX(x);
        setY(y);
    }

    public void setX(Integer x) {
        if (x == null) throw new IllegalArgumentException("X не может быть null");
        if (x > 300) throw new IllegalArgumentException("X не может быть больше 300");
        this.x = x;
    }

    public void setY(Double y) {
        if (y == null) throw new IllegalArgumentException("Y не может быть null");
        if (y <= -153) throw new IllegalArgumentException("Y должен быть больше -153");
        this.y = y;
    }

    public Integer getX() { return x; }
    public Double getY() { return y; }

    @Override
    public String toString() {
        return "model.Coordinates{x=" + x + ", y=" + y + "}";
    }
}