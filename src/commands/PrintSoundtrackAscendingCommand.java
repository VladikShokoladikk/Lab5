package commands;

import collection.CollectionManager;

/** Выводит soundtrackName всех элементов по возрастанию */
public class PrintSoundtrackAscendingCommand implements Command {
    private final CollectionManager manager;

    public PrintSoundtrackAscendingCommand(CollectionManager manager) { this.manager = manager; }

    @Override
    public void execute(String[] args) {
        manager.getSoundtrackNamesAscending().forEach(System.out::println);
    }

    @Override
    public String getDescription() { return "вывести soundtrackName в порядке возрастания"; }
}