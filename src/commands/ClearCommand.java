package commands;

import collection.CollectionManager;

/** Очищает коллекцию */
public class ClearCommand implements Command {
    private final CollectionManager manager;

    public ClearCommand(CollectionManager manager) { this.manager = manager; }

    @Override
    public void execute(String[] args) {
        manager.clear();
        System.out.println("Коллекция очищена");
    }

    @Override
    public String getDescription() { return "очистить коллекцию"; }
}