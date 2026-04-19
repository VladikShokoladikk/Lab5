package commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Хранит все доступные команды и выполняет их по имени.
 */
public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public void register(String name, Command command) {
        commands.put(name, command);
    }

    public void execute(String name, String[] args) {
        Command cmd = commands.get(name);
        if (cmd == null) {
            System.out.println("Неизвестная команда: " + name + ". Введите help.");
            return;
        }
        cmd.execute(args);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}