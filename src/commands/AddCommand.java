package commands;

import collection.CollectionManager;
import input.HumanBeingInput;
import model.HumanBeing;

/** Добавляет новый элемент в коллекцию */
public class AddCommand implements Command {
    private final CollectionManager manager;
    private final HumanBeingInput inputHelper;

    public AddCommand(CollectionManager manager, HumanBeingInput inputHelper) {
        this.manager = manager;
        this.inputHelper = inputHelper;
    }

    @Override
    public void execute(String[] args) {
        HumanBeing human = inputHelper.input();
        manager.add(human);
        System.out.println("Элемент добавлен с id=" + human.getId());
    }

    @Override
    public String getDescription() { return "добавить новый элемент в коллекцию"; }
}