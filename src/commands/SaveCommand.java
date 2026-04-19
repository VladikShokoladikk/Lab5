package commands;

import collection.CollectionManager;
/** Сохраняет коллекцию в файл */
public class SaveCommand implements Command {
    private final CollectionManager manager;
    private final inout.CsvWriter writer;

    public SaveCommand(CollectionManager manager, inout.CsvWriter writer) {
        this.manager = manager;
        this.writer = writer;
    }

    @Override
    public void execute(String[] args) {
        writer.write(manager.getCollection());
        System.out.println("Коллекция сохранена");
    }

    @Override
    public String getDescription() { return "сохранить коллекцию в файл"; }
}