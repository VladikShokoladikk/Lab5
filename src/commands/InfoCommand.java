package commands;

import collection.CollectionManager;

/** Выводит информацию о коллекции */
public class InfoCommand implements Command {
    private final CollectionManager manager;

    public InfoCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        System.out.println(manager.getInfo());
    }

    @Override
    public String getDescription() { return "вывести информацию о коллекции"; }
}