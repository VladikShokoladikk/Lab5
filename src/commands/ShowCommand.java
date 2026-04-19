package commands;

import collection.CollectionManager;
import commands.Command;

/** Выводит все элементы коллекции */
public class ShowCommand implements Command {
    private final CollectionManager manager;

    public ShowCommand(CollectionManager manager) { this.manager = manager; }

    @Override
    public void execute(String[] args) {
        var list = manager.getAll();
        if (list.isEmpty()) { System.out.println("Коллекция пуста"); return; }
        list.forEach(System.out::println);
    }

    @Override
    public String getDescription() { return "вывести все элементы коллекции"; }
}