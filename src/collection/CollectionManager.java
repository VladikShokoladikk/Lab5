package collection;

import model.HumanBeing;

import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Управляет коллекцией объектов HumanBeing.
 * Хранит элементы в ArrayDeque, отслеживает дату инициализации.
 */
public class CollectionManager {
    private ArrayDeque<HumanBeing> collection = new ArrayDeque<>();
    private final ZonedDateTime initDate = ZonedDateTime.now();

    /** Добавить элемент в коллекцию */
    public void add(HumanBeing human) {
        collection.add(human);
    }

    /** Получить все элементы (отсортированные) */
    public List<HumanBeing> getAll() {
        return collection.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    /** Найти элемент по id, или null если не найден */
    public HumanBeing findById(Long id) {
        return collection.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /** Обновить элемент с заданным id */
    public boolean updateById(Long id, HumanBeing newData) {
        HumanBeing old = findById(id);
        if (old == null) return false;
        old.setName(newData.getName());
        old.setCoordinates(newData.getCoordinates());
        old.setHeroState(newData.isRealHero());
        old.setToothPick(newData.isHasToothpick());
        old.setImpactSpeed(newData.getImpactSpeed());
        old.setSoundTrack(newData.getSoundtrackName());
        old.setWait(newData.getMinutesOfWaiting());
        old.giveWeapon(newData.getWeaponType());
        old.giveCar(newData.getCar());
        return true;
    }

    /** Удалить элемент по id */
    public boolean removeById(Long id) {
        return collection.removeIf(h -> h.getId().equals(id));
    }

    /** Вывести и удалить первый элемент */
    public HumanBeing removeHead() {
        return collection.poll(); // null если коллекция пуста
    }

    /** Очистить коллекцию */
    public void clear() {
        collection.clear();
    }

    /** Добавить элемент, если он больше максимального */
    public boolean addIfMax(HumanBeing human) {
        HumanBeing max = collection.stream()
                .max(HumanBeing::compareTo)
                .orElse(null);
        if (max == null || human.compareTo(max) > 0) {
            collection.add(human);
            return true;
        }
        return false;
    }

    /** Удалить все элементы, превышающие заданный */
    public int removeGreater(HumanBeing human) {
        int before = collection.size();
        collection.removeIf(h -> h.compareTo(human) > 0);
        return before - collection.size();
    }

    /** Удалить один элемент с заданным impactSpeed */
    public boolean removeAnyByImpactSpeed(int speed) {
        HumanBeing found = collection.stream()
                .filter(h -> h.getImpactSpeed() == speed)
                .findFirst()
                .orElse(null);
        if (found != null) {
            collection.remove(found);
            return true;
        }
        return false;
    }

    /** Среднее значение minutesOfWaiting */
    public double averageMinutesOfWaiting() {
        return collection.stream()
                .mapToDouble(HumanBeing::getMinutesOfWaiting)
                .average()
                .orElse(0);
    }

    /** Все soundtrackName в порядке возрастания */
    public List<String> getSoundtrackNamesAscending() {
        return collection.stream()
                .map(HumanBeing::getSoundtrackName)
                .sorted()
                .collect(Collectors.toList());
    }

    /** Информация о коллекции */
    public String getInfo() {
        return "Тип: " + collection.getClass().getName() + "\n" +
                "Дата инициализации: " + initDate + "\n" +
                "Количество элементов: " + collection.size();
    }

    /** Получить сырую коллекцию (для сохранения в файл) */
    public ArrayDeque<HumanBeing> getCollection() {
        return collection;
    }

    /** Заменить коллекцию (при загрузке из файла) */
    public void setCollection(ArrayDeque<HumanBeing> collection) {
        this.collection = collection;
    }
}