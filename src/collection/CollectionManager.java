package collection;

import model.HumanBeing;

import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Управляет коллекцией объектов HumanBeing.
 * Хранит элементы в ArrayDeque, отслеживает дату инициализации.
 */
public class CollectionManager {
    private ArrayDeque<HumanBeing> collection = new ArrayDeque<>();
    private final ZonedDateTime initDate = ZonedDateTime.now();

    /**
     * Добавляет элемент в конец коллекции.
     *
     * @param human объект для добавления
     */
    public void add(HumanBeing human) {
        collection.add(human);
    }

    /**
     * Возвращает все элементы коллекции, отсортированные по умолчанию.
     *
     * @return отсортированный список элементов
     */
    public List<HumanBeing> getAll() {
        return collection.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Ищет элемент по id.
     *
     * @param id идентификатор элемента
     * @return найденный объект или null если не найден
     */
    public HumanBeing findById(Long id) {
        return collection.stream().filter(h -> h.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Обновляет поля элемента с заданным id.
     * Id и дата создания не изменяются.
     *
     * @param id      идентификатор элемента
     * @param newData объект с новыми данными
     * @return true если элемент найден и обновлён, false если не найден
     */
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

    /**
     * Удаляет элемент с заданным id.
     *
     * @param id идентификатор элемента
     * @return true если элемент найден и удалён, false если не найден
     */
    public boolean removeById(Long id) {
        return collection.removeIf(h -> h.getId().equals(id));
    }

    /**
     * Возвращает и удаляет первый элемент коллекции.
     *
     * @return первый элемент или null если коллекция пуста
     */
    public HumanBeing removeHead() {
        return collection.poll();
    }

    /**
     * Очищает коллекцию.
     */
    public void clear() {
        collection.clear();
    }

    /**
     * Добавляет элемент если он больше максимального в коллекции.
     *
     * @param human объект для сравнения и возможного добавления
     * @return true если элемент добавлен, false если не является максимальным
     */
    public boolean addIfMax(HumanBeing human) {
        HumanBeing max = collection.stream().max(HumanBeing::compareTo).orElse(null);
        if (max == null || human.compareTo(max) > 0) {
            collection.add(human);
            return true;
        }
        return false;
    }

    /**
     * Удаляет все элементы коллекции, превышающие заданный.
     *
     * @param human эталонный объект для сравнения
     * @return количество удалённых элементов
     */
    public int removeGreater(HumanBeing human) {
        int before = collection.size();
        collection.removeIf(h -> h.compareTo(human) > 0);
        return before - collection.size();
    }

    /**
     * Удаляет один элемент с заданным значением impactSpeed.
     *
     * @param speed значение impactSpeed для поиска
     * @return true если элемент найден и удалён, false если не найден
     */
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

    /**
     * Вычисляет среднее значение поля minutesOfWaiting по всей коллекции.
     *
     * @return среднее значение или 0 если коллекция пуста
     */
    public double averageMinutesOfWaiting() {
        return collection.stream()
                .mapToDouble(HumanBeing::getMinutesOfWaiting)
                .average()
                .orElse(0);
    }

    /**
     * Возвращает все значения soundtrackName в порядке возрастания.
     *
     * @return отсортированный список названий саундтреков
     */
    public List<String> getSoundtrackNamesAscending() {
        return collection.stream()
                .map(HumanBeing::getSoundtrackName)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Возвращает строку с информацией о коллекции.
     *
     * @return тип коллекции, дата инициализации, количество элементов
     */
    public String getInfo() {
        return "Тип: " + collection.getClass().getName() + "\n" +
                "Дата инициализации: " + initDate + "\n" +
                "Количество элементов: " + collection.size();
    }

    /**
     * Возвращает коллекцию напрямую (используется при сохранении в файл).
     *
     * @return текущая коллекция
     */
    public ArrayDeque<HumanBeing> getCollection() {
        return collection;
    }

    /**
     * Заменяет коллекцию (используется при загрузке из файла).
     *
     * @param collection новая коллекция
     */
    public void setCollection(ArrayDeque<HumanBeing> collection) {
        this.collection = collection;
    }
}