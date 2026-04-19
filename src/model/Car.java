package model;

public class Car {
    private String name; //Поле не может быть null
    private Boolean cool; //Поле не может быть null
    public Car(String name, Boolean cool) {
        setName(name);
        setCool(cool);
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("Имя не может быть null");
        this.name = name;
    }

    public void setCool(Boolean cool) {
        if (cool == null) throw new IllegalArgumentException("Крутость бинарна: либо да, либо нет (⌐■_■)");
        this.cool = cool;
    }
    public String getName() { return this.name; }
    public Boolean isCool() { return this.cool; }

    @Override
    public String toString() {
        return "model.Car{name='" + name + "', cool=" + cool + "}";
    }
}