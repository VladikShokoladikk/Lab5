package commands;

import collection.CollectionManager;

/** Удаляет элемент по id */
public class RemoveByIdCommand implements Command {
    private final CollectionManager manager;

    public RemoveByIdCommand(CollectionManager manager) { this.manager = manager; }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) { System.out.println("Укажите id"); return; }
        try {
            Long id = Long.parseLong(args[0]);
            if (manager.removeById(id)) System.out.println("Элемент удалён");
            else System.out.println("Элемент с id=" + id + " не найден");
        } catch (NumberFormatException e) {
            System.out.println("id должен быть числом");
        }
    }

    @Override
    public String getDescription() { return "удалить элемент по id"; }
}