package commands;

public class EshkereCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("эщкере");
    }

    @Override
    public String getDescription() { return "эщкере"; }
}