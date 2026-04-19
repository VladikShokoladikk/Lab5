package commands;

/** Завершает программу */
public class ExitCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Выход");
        System.exit(0);
    }

    @Override
    public String getDescription() { return "завершить программу без сохранения"; }
}