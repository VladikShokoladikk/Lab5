package inout;

import model.*;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;

/**
 * Читает коллекцию HumanBeing из CSV-файла.
 * Использует InputStreamReader, как требует задание.
 */
public class CsvReader {

    /**
     * Читает файл по пути из переменной окружения DATA_FILE.
     * @return заполненная коллекция, или пустая если файл не найден/битый
     */
    public ArrayDeque<HumanBeing> read() {
        ArrayDeque<HumanBeing> result = new ArrayDeque<>();
        String path = System.getenv("DATA_FILE");

        if (path == null) {
            System.err.println("Переменная окружения DATA_FILE не задана");
            return result;
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(path)))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; } // пропускаем заголовок
                if (line.isBlank()) continue;

                try {
                    HumanBeing human = parseLine(line);
                    result.add(human);
                    HumanBeing.updateLastID(human.getId());
                } catch (Exception e) {
                    System.err.println("Пропущена строка (ошибка парсинга): " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + path);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        return result;
    }

    private HumanBeing parseLine(String line) {
        String[] f = line.split(",");
        // порядок полей: id,name,x,y,creationDate,realHero,hasToothpick,
        //                impactSpeed,soundtrackName,minutesOfWaiting,weaponType,carName,carCool
        Long id = Long.parseLong(f[0].trim());
        String name = f[1].trim();
        Integer x = Integer.parseInt(f[2].trim());
        Double y = Double.parseDouble(f[3].trim());
        ZonedDateTime creationDate = ZonedDateTime.parse(f[4].trim());
        Boolean realHero = Boolean.parseBoolean(f[5].trim());
        boolean hasToothpick = Boolean.parseBoolean(f[6].trim());
        int impactSpeed = Integer.parseInt(f[7].trim());
        String soundtrackName = f[8].trim();
        float minutesOfWaiting = Float.parseFloat(f[9].trim());
        WeaponType weaponType = WeaponType.valueOf(f[10].trim());
        String carName = f[11].trim();
        Boolean carCool = Boolean.parseBoolean(f[12].trim());

        return new HumanBeing(id, creationDate, name,
                new Coordinates(x, y), realHero, hasToothpick,
                impactSpeed, soundtrackName, minutesOfWaiting,
                weaponType, new Car(carName, carCool));
    }
}