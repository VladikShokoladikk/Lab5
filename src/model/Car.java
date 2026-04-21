package model;

/**
 * Представляет автомобиль человека(HumanBeing).
 */
public class Car {
    private String name;
    private Boolean cool;

    /**
     * @param name название автомобиля, не может быть null
     * @param cool является ли автомобиль крутым, не может быть null
     */
    public Car(String name, Boolean cool) {
        setName(name);
        setCool(cool);
    }

    /**
     * @param name название автомобиля
     * @throws IllegalArgumentException если name равен null
     */
    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Имя не может быть null");
        this.name = name;
    }

    /**
     * @param cool крутость автомобиля
     * @throws IllegalArgumentException если cool равен null
     */
    public void setCool(Boolean cool) {
        if (cool == null) throw new IllegalArgumentException("Крутость бинарна: либо да, либо нет (⌐■_■)");
        this.cool = cool;
    }

    /** @return название автомобиля */
    public String getName() { return this.name; }

    /** @return крутость автомобиля */
    public Boolean isCool() { return this.cool; }

    @Override
    public String toString() {
        return "Car{name='" + name + "', cool=" + cool + "}";
    }
}