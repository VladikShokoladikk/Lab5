package commands;

import collection.CollectionManager;

/** Выводит и удаляет первый элемент */
public class RemoveHeadCommand implements Command {
    private final CollectionManager manager;

    public RemoveHeadCommand(CollectionManager manager) { this.manager = manager; }

    @Override
    public void execute(String[] args) {
        var head = manager.removeHead();
        if (head == null) System.out.println("Коллекция пуста");
        else System.out.println("Удалён: " + head);
    }

    @Override
    public String getDescription() { return "вывести и удалить первый элемент"; }
}