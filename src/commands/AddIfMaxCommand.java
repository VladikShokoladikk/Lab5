package commands;

import collection.CollectionManager;
import input.HumanBeingInput;
import model.HumanBeing;

/**
 * Команда добавления элемента в коллекцию, если он больше максимального.
 * Сравнение выполняется через compareTo из HumanBeing.
 */
public class AddIfMaxCommand implements Command {
    private final CollectionManager manager;
    private final HumanBeingInput inputHelper;

    /**
     * @param inputHelper помощник для ввода объекта
     */
    public AddIfMaxCommand(CollectionManager manager, HumanBeingInput inputHelper) {
        this.manager = manager;
        this.inputHelper = inputHelper;
    }

    /**
     * Запрашивает данные у пользователя и добавляет объект только если он
     * превышает максимальный элемент коллекции.
     *
     * @param args не используются
     */
    @Override
    public void execute(String[] args) {
        HumanBeing human = inputHelper.input();
        if (manager.addIfMax(human)) System.out.println("Элемент добавлен");
        else System.out.println("Элемент не является максимальным, не добавлен");
    }

    /** @return описание команды для help */
    @Override
    public String getDescription() { return "добавить элемент если он больше максимального"; }
}