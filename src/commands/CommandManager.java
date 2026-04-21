package commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Хранит все доступные команды и выполняет их по имени.
 */
public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Регистрирует команду под заданным именем.
     *
     * @param name    имя команды (то что вводит пользователь)
     * @param command объект команды
     */
    public void register(String name, Command command) {
        commands.put(name, command);
    }

    /**
     * Выполняет команду по имени.
     * Если команда не найдена — выводит сообщение об ошибке.
     *
     * @param name имя команды
     * @param args аргументы команды типа String
     */
    public void execute(String name, String[] args) {
        Command cmd = commands.get(name);
        if (cmd == null) {
            System.out.println("Неизвестная команда: " + name + ". Введите help.");
            return;
        }
        cmd.execute(args);
    }

    /**
     * @return все зарегистрированные команды
     */
    public Map<String, Command> getCommands() {
        return commands;
    }
}