package commands;

import collection.CollectionManager;
import input.HumanBeingInput;
import model.HumanBeing;

/**
 * Команда добавления нового элемента в коллекцию.
 * Запрашивает данные у пользователя через HumanBeingInput.
 */
public class AddCommand implements Command {
    private final CollectionManager manager;
    private final HumanBeingInput inputHelper;

    /**
     * @param manager     менеджер коллекции
     * @param inputHelper помощник для ввода объекта
     */
    public AddCommand(CollectionManager manager, HumanBeingInput inputHelper) {
        this.manager = manager;
        this.inputHelper = inputHelper;
    }

    /**
     * Запрашивает данные у пользователя и добавляет новый объект в коллекцию.
     *
     * @param args не используются
     */
    @Override
    public void execute(String[] args) {
        HumanBeing human = inputHelper.input();
        manager.add(human);
        System.out.println("Элемент добавлен с id=" + human.getId());
    }

    /** @return описание команды для help */
    @Override
    public String getDescription() { return "добавить новый элемент в коллекцию"; }
}