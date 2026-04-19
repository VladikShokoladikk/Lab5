package commands;

/**
 * Интерфейс для всех команд приложения.
 */
public interface Command {
    /** Выполнить команду с заданными аргументами */
    void execute(String[] args);

    /** Краткое описание команды для help */
    String getDescription();
}