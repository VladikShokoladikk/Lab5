package commands;

import collection.CollectionManager;

/** Очищает коллекцию */
public class ClearCommand implements Command {
    private final CollectionManager manager;

    /**
     * @param manager менеджер коллекции
     */
    public ClearCommand(CollectionManager manager) { this.manager = manager; }

    /**
     * Очищает коллекцию
     * @param args не используется
     */
    @Override
    public void execute(String[] args) {
        manager.clear();
        System.out.println("Коллекция очищена");
    }

    @Override
    public String getDescription() { return "очистить коллекцию"; }
}