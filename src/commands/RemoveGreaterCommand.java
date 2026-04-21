package commands;

import collection.CollectionManager;
import input.HumanBeingInput;
import model.HumanBeing;

/**
 * Команда удаления всех элементов коллекции, превышающих заданный.
 * Сравнение выполняется через compareTo из HumanBeing.
 */
public class RemoveGreaterCommand implements Command {
    private final CollectionManager manager;
    private final HumanBeingInput inputHelper;

    /**
     * @param manager     менеджер коллекции
     * @param inputHelper помощник для ввода объекта
     */
    public RemoveGreaterCommand(CollectionManager manager, HumanBeingInput inputHelper) {
        this.manager = manager;
        this.inputHelper = inputHelper;
    }

    /**
     * Запрашивает данные у пользователя и удаляет все элементы коллекции,
     * которые превышают введённый объект.
     *
     * @param args не используются
     */
    @Override
    public void execute(String[] args) {
        HumanBeing human = inputHelper.input();
        int removed = manager.removeGreater(human);
        System.out.println("Удалено элементов: " + removed);
    }

    /** @return описание команды для help */
    @Override
    public String getDescription() { return "удалить все элементы больше заданного"; }
}