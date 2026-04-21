package model;

import java.time.ZonedDateTime;

/**
 * Представляет персонажа коллекции.
 * Реализует сортировку по имени, затем по id, затем по дате создания.
 */
public class HumanBeing implements Comparable<HumanBeing> {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private Boolean realHero;
    private boolean hasToothpick;
    private int impactSpeed;
    private String soundtrackName;
    private float minutesOfWaiting;
    private WeaponType weaponType;
    private Car car;

    private static Long lastID = 1L;

    /**
     * Конструктор для создания нового объекта (id и дата генерируются автоматически).
     *
     * @param name           имя персонажа, не может быть null или пустым
     * @param coordinates    координаты персонажа, не может быть null
     * @param realHero       является ли персонаж настоящим героем, не может быть null
     * @param hasToothpick   есть ли зубочистка
     * @param impactSpeed    скорость удара
     * @param soundtrackName название саундтрека, не может быть null
     * @param minutesOfWaiting минуты ожидания
     * @param weaponType     тип оружия, не может быть null
     * @param car            автомобиль персонажа, не может быть null
     */
    public HumanBeing(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick,
                      int impactSpeed, String soundtrackName, float minutesOfWaiting,
                      WeaponType weaponType, Car car) {
        this.setID(++lastID);
        this.setName(name);
        this.setCreationDate(ZonedDateTime.now());
        this.setCoordinates(coordinates);
        this.setHeroState(realHero);
        this.setToothPick(hasToothpick);
        this.setImpactSpeed(impactSpeed);
        this.setSoundTrack(soundtrackName);
        this.giveWeapon(weaponType);
        this.giveCar(car);
        this.setWait(minutesOfWaiting);
    }

    /**
     * Конструктор для восстановления объекта из файла (id и дата передаются явно).
     *
     * @param id             уникальный идентификатор, больше 0, не может быть null
     * @param creationDate   дата создания, не может быть null
     * @param name           имя персонажа, не может быть null или пустым
     * @param coordinates    координаты персонажа, не может быть null
     * @param realHero       является ли персонаж настоящим героем, не может быть null
     * @param hasToothpick   есть ли зубочистка
     * @param impactSpeed    скорость удара
     * @param soundtrackName название саундтрека, не может быть null
     * @param minutesOfWaiting минуты ожидания
     * @param weaponType     тип оружия, не может быть null
     * @param car            автомобиль персонажа, не может быть null
     */
    public HumanBeing(Long id, ZonedDateTime creationDate, String name, Coordinates coordinates,
                      Boolean realHero, boolean hasToothpick, int impactSpeed, String soundtrackName,
                      float minutesOfWaiting, WeaponType weaponType, Car car) {
        this.setID(id);
        this.setCreationDate(creationDate);
        this.setName(name);
        this.setCoordinates(coordinates);
        this.setHeroState(realHero);
        this.setToothPick(hasToothpick);
        this.setImpactSpeed(impactSpeed);
        this.setSoundTrack(soundtrackName);
        this.giveWeapon(weaponType);
        this.giveCar(car);
        this.setWait(minutesOfWaiting);
    }

    /**
     * @param id уникальный идентификатор
     * @throws IllegalArgumentException если id равен null или меньше/равен 0
     */
    private void setID(Long id) {
        if (id == null || id <= 0) throw new IllegalArgumentException("Ошибка с ID");
        this.id = id;
    }

    /**
     * @param date дата создания
     * @throws IllegalArgumentException если date равен null
     */
    private void setCreationDate(ZonedDateTime date) {
        if (date == null) throw new IllegalArgumentException("Ошибка с датой создания");
        this.creationDate = date;
    }

    /**
     * @param name имя персонажа
     * @throws IllegalArgumentException если name равен null или пустой
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Имя не может быть null или пустым");
        this.name = name;
    }

    /**
     * @param coordinates координаты персонажа
     * @throws IllegalArgumentException если coordinates равен null
     */
    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) throw new IllegalArgumentException("Объект не может находиться в \"нигде\"");
        this.coordinates = coordinates;
    }

    /**
     * @param heroState является ли персонаж настоящим героем
     * @throws IllegalArgumentException если heroState равен null
     */
    public void setHeroState(Boolean heroState) {
        if (heroState == null) throw new IllegalArgumentException("Либо герой либо нет, третьего не дано");
        this.realHero = heroState;
    }

    /**
     * @param soundtrackName название саундтрека
     * @throws IllegalArgumentException если soundtrackName равен null
     */
    public void setSoundTrack(String soundtrackName) {
        if (soundtrackName == null) throw new IllegalArgumentException("Ошибка с саундтреком");
        this.soundtrackName = soundtrackName;
    }

    /**
     * @param weaponType тип оружия
     * @throws IllegalArgumentException если weaponType равен null
     */
    public void giveWeapon(WeaponType weaponType) {
        if (weaponType == null) throw new IllegalArgumentException("Дальше без оружия идти опасно");
        this.weaponType = weaponType;
    }

    /**
     * @param car автомобиль персонажа
     * @throws IllegalArgumentException если car равен null
     */
    public void giveCar(Car car) {
        if (car == null) throw new IllegalArgumentException("Без машины нельзя");
        this.car = car;
    }

    /** @param tooth наличие зубочистки */
    public void setToothPick(boolean tooth) {
        this.hasToothpick = tooth;
    }

    /** @param minutes минуты ожидания */
    public void setWait(float minutes) {
        this.minutesOfWaiting = minutes;
    }

    /** @param impactSpeed скорость удара */
    public void setImpactSpeed(int impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    /**
     * Сравнивает по имени, затем по id, затем по дате создания.
     *
     * @param other другой объект для сравнения
     * @return отрицательное, 0 или положительное число
     */
    @Override
    public int compareTo(HumanBeing other) {
        if (other == null) return 1;
        int result = this.name.compareTo(other.name);
        if (result == 0) result = this.id.compareTo(other.id);
        if (result == 0) result = this.creationDate.compareTo(other.creationDate);
        return result;
    }

    /** @return уникальный идентификатор */
    public Long getId() { return id; }
    /** @return имя персонажа */
    public String getName() { return name; }
    /** @return координаты персонажа */
    public Coordinates getCoordinates() { return coordinates; }
    /** @return дата создания */
    public ZonedDateTime getCreationDate() { return creationDate; }
    /** @return является ли персонаж настоящим героем */
    public Boolean isRealHero() { return realHero; }
    /** @return есть ли зубочистка */
    public boolean isHasToothpick() { return hasToothpick; }
    /** @return скорость удара */
    public int getImpactSpeed() { return impactSpeed; }
    /** @return название саундтрека */
    public String getSoundtrackName() { return soundtrackName; }
    /** @return минуты ожидания */
    public float getMinutesOfWaiting() { return minutesOfWaiting; }
    /** @return тип оружия */
    public WeaponType getWeaponType() { return weaponType; }
    /** @return автомобиль персонажа */
    public Car getCar() { return car; }

    @Override
    public String toString() {
        return "HumanBeing{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", realHero=" + realHero +
                ", hasToothpick=" + hasToothpick +
                ", impactSpeed=" + impactSpeed +
                ", soundtrackName='" + soundtrackName + "'" +
                ", minutesOfWaiting=" + minutesOfWaiting +
                ", weaponType=" + weaponType +
                ", car=" + car +
                "}";
    }

    /**
     * Обновляет lastID при загрузке объектов из файла.
     * Гарантирует что новые объекты получат уникальный id.
     *
     * @param id id загруженного объекта
     */
    public static void updateLastID(Long id) {
        if (id > lastID) lastID = id;
    }
}