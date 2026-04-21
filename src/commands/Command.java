package commands;

/**
 * Интерфейс для всех команд приложения.
 */
public interface Command {
    /** Выполнить команду с заданными аргументами
     *
     * @param args аргументы команды типа String
     */
    void execute(String[] args);

    /** Краткое описание команды для help */
    String getDescription();
}