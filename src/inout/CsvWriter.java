package inout;

import model.HumanBeing;
import java.io.*;
import java.util.ArrayDeque;

/**
 * Сохраняет коллекцию HumanBeing в CSV-файл.
 * Использует FileOutputStream, как требует задание.
 */
public class CsvWriter {

    private static final String HEADER =
            "id,name,x,y,creationDate,realHero,hasToothpick," +
                    "impactSpeed,soundtrackName,minutesOfWaiting,weaponType,carName,carCool\n";

    /**
     * Записывает коллекцию в файл из переменной окружения DATA_FILE.
     * @param collection коллекция для сохранения
     */
    public void write(ArrayDeque<HumanBeing> collection) {
        String path = System.getenv("DATA_FILE");

        if (path == null) {
            System.err.println("Переменная окружения DATA_FILE не задана");
            return;
        }

        try (PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(path)))) {

            writer.print(HEADER);
            for (HumanBeing h : collection) {
                writer.println(toCsvLine(h));
            }

        } catch (FileNotFoundException e) {
            System.err.println("Нет доступа к файлу: " + path);
        }
    }

    private String toCsvLine(HumanBeing h) {
        return String.join(",",
                h.getId().toString(),
                h.getName(),
                h.getCoordinates().getX().toString(),
                h.getCoordinates().getY().toString(),
                h.getCreationDate().toString(),
                h.isRealHero().toString(),
                String.valueOf(h.isHasToothpick()),
                String.valueOf(h.getImpactSpeed()),
                h.getSoundtrackName(),
                String.valueOf(h.getMinutesOfWaiting()),
                h.getWeaponType().toString(),
                h.getCar().getName(),
                h.getCar().isCool().toString()
        );
    }
}