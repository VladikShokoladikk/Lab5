package commands;

import collection.CollectionManager;
import input.HumanBeingInput;
import model.HumanBeing;

/** Удаляет все элементы больше заданного */
public class RemoveGreaterCommand implements Command {
    private final CollectionManager manager;
    private final HumanBeingInput inputHelper;

    public RemoveGreaterCommand(CollectionManager manager, HumanBeingInput inputHelper) {
        this.manager = manager;
        this.inputHelper = inputHelper;
    }

    @Override
    public void execute(String[] args) {
        HumanBeing human = inputHelper.input();
        int removed = manager.removeGreater(human);
        System.out.println("Удалено элементов: " + removed);
    }

    @Override
    public String getDescription() { return "удалить все элементы больше заданного"; }
}