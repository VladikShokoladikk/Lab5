package commands;
/**
 * Тестовая разработка американских учёных из FentLA|3 2o77 4 c00l guy$
 */
public class EshkereCommand implements Command {
    /**
     * Екзекуция скебоба
     *
     * @param args введение СВАГИ
     */
    @Override
    public void execute(String[] args) {
        System.out.println("эщкере");
    }

    /**
     * Возвращение блудного сына
     *
     * @return абаюдна
     */
    @Override
    public String getDescription() { return "эщкере"; }
}