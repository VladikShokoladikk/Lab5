package commands;

import collection.CollectionManager;

/** Удаляет один элемент по impactSpeed */
public class RemoveAnyByImpactSpeedCommand implements Command {
    private final CollectionManager manager;

    public RemoveAnyByImpactSpeedCommand(CollectionManager manager) { this.manager = manager; }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) { System.out.println("Укажите impactSpeed"); return; }
        try {
            int speed = Integer.parseInt(args[0]);
            if (manager.removeAnyByImpactSpeed(speed)) System.out.println("Элемент удалён");
            else System.out.println("Элемент с impactSpeed=" + speed + " не найден");
        } catch (NumberFormatException e) {
            System.out.println("impactSpeed должен быть числом");
        }
    }

    @Override
    public String getDescription() { return "удалить один элемент по impactSpeed"; }
}