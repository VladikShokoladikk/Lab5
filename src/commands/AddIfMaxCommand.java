package commands;

import collection.CollectionManager;
import commands.Command;
import input.HumanBeingInput;
import model.HumanBeing;

/** Добавляет элемент если он больше максимального */
public class AddIfMaxCommand implements Command {
    private final CollectionManager manager;
    private final HumanBeingInput inputHelper;

    public AddIfMaxCommand(CollectionManager manager, HumanBeingInput inputHelper) {
        this.manager = manager;
        this.inputHelper = inputHelper;
    }

    @Override
    public void execute(String[] args) {
        HumanBeing human = inputHelper.input();
        if (manager.addIfMax(human)) System.out.println("Элемент добавлен");
        else System.out.println("Элемент не является максимальным, не добавлен");
    }

    @Override
    public String getDescription() { return "добавить элемент если он больше максимального"; }
}