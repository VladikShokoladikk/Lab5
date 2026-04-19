package commands;

import collection.CollectionManager;

/** Выводит среднее minutesOfWaiting */
public class AverageMinutesCommand implements Command {
    private final CollectionManager manager;

    public AverageMinutesCommand(CollectionManager manager) { this.manager = manager; }

    @Override
    public void execute(String[] args) {
        System.out.println("Среднее minutesOfWaiting: " + manager.averageMinutesOfWaiting());
    }

    @Override
    public String getDescription() { return "вывести среднее значение minutesOfWaiting"; }
}