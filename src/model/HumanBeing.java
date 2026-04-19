package model;

import java.time.ZonedDateTime;

public class HumanBeing implements Comparable<HumanBeing>{
    private Long id; //Изначально > 0 и не null
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private int impactSpeed;
    private String soundtrackName; //Поле не может быть null
    private float minutesOfWaiting;
    private WeaponType weaponType; //Поле не может быть null
    private Car car; //Поле не может быть null

    static private Long lastID = 1L; //при чтении из файла надо не забыть заменить его на максимальный id
    public HumanBeing(String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, int impactSpeed,String soundtrackName, float minutesOfWaiting,WeaponType weaponType, Car car) {
        this.setID(++lastID);
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
    public HumanBeing(Long id, java.time.ZonedDateTime creationDate, String name, Coordinates coordinates, Boolean realHero, boolean hasToothpick, int impactSpeed,String soundtrackName, float minutesOfWaiting,WeaponType weaponType, Car car) {
        this.setID(id); //возможно надо проверять пересечения и переназначать id
        this.setCreationDate(creationDate);
        this.setCoordinates(coordinates);
        this.setHeroState(realHero);
        this.setToothPick(hasToothpick);
        this.setImpactSpeed(impactSpeed);
        this.setSoundTrack(soundtrackName);
        this.giveWeapon(weaponType);
        this.giveCar(car);
        this.setWait(minutesOfWaiting);


    }
    private void setID(Long id){
        if (id == null || id <= 0) throw new IllegalArgumentException("Ошибка с ID");
        this.id = id;
    }
    private void setCreationDate(java.time.ZonedDateTime date){
        if (date == null) throw new IllegalArgumentException("Ошибка с датой создания");
        this.creationDate = date;
    }
    public void setName(String name){
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Имя не может быть null или пустым");
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates){
        if (coordinates == null) throw new IllegalArgumentException("Обьект не может находиться в \"нигде\"");
        this.coordinates = coordinates;
    }
    public void setHeroState(Boolean heroState){
        if (heroState == null) throw new IllegalArgumentException("Либо герой либо нет, третьего не дано");
        this.realHero = heroState;
    }
    public void setSoundTrack(String soundtrackName) {
        if (soundtrackName == null) throw new IllegalArgumentException("Ошибка с саундтреком");
        this.soundtrackName = soundtrackName;
    }
    public void giveWeapon(WeaponType weaponType) {
        if (weaponType == null) throw new IllegalArgumentException("Дальше без оружия идти опасно");
        this.weaponType = weaponType;
    }
    public void giveCar(Car car) {
        if (car == null) throw new IllegalArgumentException("Без машины нельзя");
        this.car = car;
    }
    public void setToothPick(boolean tooth) {
        //if (tooth == null) throw new IllegalArgumentException("зубочистка сломана");
        this.hasToothpick = tooth;
    }
    public void setWait(float minutes) {
        //if (minutes == null) throw new IllegalArgumentException("не дождались");
        this.minutesOfWaiting = minutes;
    }
    public void setImpactSpeed(int impactSpeed) {
        //if (impactSpeed == null || impactSpeed < 0) throw new IllegalArgumentException("скорость удара слабенькая");
        this.impactSpeed = impactSpeed;
    }
    @Override
    public int compareTo(HumanBeing other) {
        if (other == null) return 1;

        int result = this.name.compareTo(other.name);//сортировка по имени
        if (result == 0) {
            result = this.id.compareTo(other.id); // и по id
        }
        if (result == 0) {
            result = this.creationDate.compareTo(other.creationDate); //и по времени на всякий
        }
        return result;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public Coordinates getCoordinates() { return coordinates; }
    public ZonedDateTime getCreationDate() { return creationDate; }
    public Boolean isRealHero() { return realHero; }
    public boolean isHasToothpick() { return hasToothpick; }
    public int getImpactSpeed() { return impactSpeed; }
    public String getSoundtrackName() { return soundtrackName; }
    public float getMinutesOfWaiting() { return minutesOfWaiting; }
    public WeaponType getWeaponType() { return weaponType; }
    public Car getCar() { return car; }

    @Override
    public String toString() {
        return "model.HumanBeing{" +
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
    public static void updateLastID(Long id) {
        if (id > lastID) lastID = id;
    }
}

