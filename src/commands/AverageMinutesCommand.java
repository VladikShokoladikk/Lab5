package commands;

import collection.CollectionManager;

/** Выводит среднее minutesOfWaiting */
public class AverageMinutesCommand implements Command {
    private final CollectionManager manager;

    /**
     * @param manager менеджер коллекции
     */
    public AverageMinutesCommand(CollectionManager manager) { this.manager = manager; }

    /**
     *
     * @param args не используется
     */
    @Override
    public void execute(String[] args) {
        System.out.println("Среднее minutesOfWaiting: " + manager.averageMinutesOfWaiting());
    }

    /** @return описание команды для help */
    @Override
    public String getDescription() { return "вывести среднее значение minutesOfWaiting"; }
}