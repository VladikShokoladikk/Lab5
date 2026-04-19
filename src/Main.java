import collection.CollectionManager;
import commands.*;
import inout.CsvReader;
import inout.CsvWriter;
import input.HumanBeingInput;

import java.util.Scanner;

/**
 * Точка входа. Инициализирует всё и запускает главный цикл.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CollectionManager manager = new CollectionManager();
        CsvReader reader = new CsvReader();
        CsvWriter writer = new CsvWriter();
        HumanBeingInput inputHelper = new HumanBeingInput(scanner);

        // Загружаем коллекцию из файла при старте
        manager.setCollection(reader.read());
        System.out.println("Коллекция загружена: " + manager.getCollection().size() + " элементов");

        // Регистрируем команды
        CommandManager commandManager = new CommandManager();

        commandManager.register("help",         new HelpCommand(commandManager));
        commandManager.register("info",         new InfoCommand(manager));
        commandManager.register("show",         new ShowCommand(manager));
        commandManager.register("add",          new AddCommand(manager, inputHelper));
        commandManager.register("update",       new UpdateCommand(manager, inputHelper));
        commandManager.register("remove_by_id", new RemoveByIdCommand(manager));
        commandManager.register("clear",        new ClearCommand(manager));
        commandManager.register("save",         new SaveCommand(manager, writer));
        commandManager.register("exit",         new ExitCommand());
        commandManager.register("remove_head",  new RemoveHeadCommand(manager));
        commandManager.register("add_if_max",   new AddIfMaxCommand(manager, inputHelper));
        commandManager.register("remove_greater", new RemoveGreaterCommand(manager, inputHelper));
        commandManager.register("remove_any_by_impact_speed", new RemoveAnyByImpactSpeedCommand(manager));
        commandManager.register("average_of_minutes_of_waiting", new AverageMinutesCommand(manager));
        commandManager.register("print_field_ascending_soundtrack_name", new PrintSoundtrackAscendingCommand(manager));
        commandManager.register("execute_script", new ExecuteScriptCommand(commandManager));

        // Главный цикл
        System.out.println("Введите команду (help — список команд):");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isBlank()) continue;

            String[] parts = line.split("\\s+", 2);
            String cmdName = parts[0];
            String[] cmdArgs = parts.length > 1 ? parts[1].split("\\s+") : new String[0];

            commandManager.execute(cmdName, cmdArgs);
        }
    }
}