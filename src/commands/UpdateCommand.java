package commands;

import collection.CollectionManager;
import input.HumanBeingInput;
import model.HumanBeing;

/** Обновляет элемент по id */
public class UpdateCommand implements Command {
    private final CollectionManager manager;
    private final HumanBeingInput inputHelper;

    public UpdateCommand(CollectionManager manager, HumanBeingInput inputHelper) {
        this.manager = manager;
        this.inputHelper = inputHelper;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) { System.out.println("Укажите id"); return; }
        try {
            Long id = Long.parseLong(args[0]);
            if (manager.findById(id) == null) {
                System.out.println("Элемент с id=" + id + " не найден");
                return;
            }
            HumanBeing newData = inputHelper.input();
            manager.updateById(id, newData);
            System.out.println("Элемент обновлён");
        } catch (NumberFormatException e) {
            System.out.println("id должен быть числом");
        }
    }

    @Override
    public String getDescription() { return "обновить элемент по id"; }
}