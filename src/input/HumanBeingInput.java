package input;

import model.*;
import java.util.Scanner;

/**
 * Интерактивный ввод объекта HumanBeing от пользователя.
 */
public class HumanBeingInput {
    private final Scanner scanner;
    /**
     * @param scanner сканнер для чтения пользовательского ввода
     */
    public HumanBeingInput(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Запрашивает все поля и возвращает собранный объект HumanBeing.
     *
     * @return новый объект HumanBeing
     */
    public HumanBeing input() {
        String name = askString("Введите имя (не пустое): ", false);
        Coordinates coordinates = inputCoordinates();
        Boolean realHero = askBoolean("Настоящий герой? (true/false): ");
        boolean hasToothpick = askBoolean("Есть зубочистка? (true/false): ");
        int impactSpeed = askInt("Введите скорость удара (целое число): ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        String soundtrackName = askString("Введите название саундтрека: ", false);
        float minutesOfWaiting = askFloat("Введите минуты ожидания (целое число): ");
        WeaponType weaponType = askWeaponType();
        Car car = inputCar();

        return new HumanBeing(name, coordinates, realHero, hasToothpick,
                impactSpeed, soundtrackName, minutesOfWaiting, weaponType, car);
    }
    /**
     * Ввод координат X и Y
     *
     * @return объект Coordinates
     */
    private Coordinates inputCoordinates() {
        System.out.println("-- Координаты --");
        Integer x = askInt("Введите X (макс 300): ", Integer.MIN_VALUE, 300);
        Double y = askDouble("Введите Y (больше -153): ", -153.0, Double.MAX_VALUE);
        return new Coordinates(x, y);
    }
    /** Ввод машины
     *
     * @return объект Car
     */
    private Car inputCar() {
        System.out.println("-- Машина --");
        String name = askString("Введите название машины: ", false);
        Boolean cool = askBoolean("Машина крутая? (true/false): ");
        return new Car(name, cool);
    }
    /** Ввод типа оружия
     *
     * @return объект enum WeaponType
     */
    private WeaponType askWeaponType() {
        System.out.println("Доступные типы оружия: " + java.util.Arrays.toString(WeaponType.values()));
        while (true) {
            System.out.print("Введите тип оружия: ");
            String input = scanner.nextLine().trim();
            try {
                return WeaponType.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: такого типа нет. Повторите ввод.");
            }
        }
    }
    /** Ввод строки
     *
     * @param prompt приглашение к вводу
     * @return объект String
     */
    private String askString(String prompt, boolean allowEmpty) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() || allowEmpty) return input;
            System.out.println("Ошибка: строка не может быть пустой.");
        }
    }
    /** Ввод бинарного значения (true/false)
     *
     * @param prompt приглашение к вводу
     * @return объект Boolean
     */
    private Boolean askBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("Ошибка: введите true или false.");
        }
    }
    /** Ввод целого числа
     *
     * @param min Минимум числа
     * @param max Максимум числа
     * @param prompt приглашение к вводу
     * @return объект Integer
     */
    private int askInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = Integer.parseInt(scanner.nextLine().trim());
                if (val >= min && val <= max) return val;
                System.out.println("Ошибка: значение должно быть от " + min + " до " + max);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }
    /** Ввод числа с точностью до сотых
     *
     * @param prompt приглашение к вводу
     * @return объект Double
     */
    private Double askDouble(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = Double.parseDouble(scanner.nextLine().trim());
                if (val > min && val <= max) return val;
                System.out.println("Ошибка: значение должно быть больше " + min);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число.");
            }
        }
    }
    /** Ввод числа с плавающей точкой
     *
     * @param prompt приглашение к вводу
     * @return объект Float
     */
    private float askFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число.");
            }
        }
    }
}