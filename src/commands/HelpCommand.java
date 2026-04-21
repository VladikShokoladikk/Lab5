package commands;

/** Выводит справку по всем командам */
public class HelpCommand implements Command {
    private final CommandManager commandManager;

    public HelpCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String[] args) {
        commandManager.getCommands()
                .forEach((name, cmd) ->
                        System.out.printf("%-40s — %s%n%n", name, cmd.getDescription()));
    }

    @Override
    public String getDescription() { return "вывести справку по командам"; }
}