package commands;

import java.io.*;

/** Считывает и выполняет команды из файла-скрипта */
public class ExecuteScriptCommand implements Command {
    private final CommandManager commandManager;

    public ExecuteScriptCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) { System.out.println("Укажите имя файла"); return; }
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.trim().split("\\s+", 2);
                String cmdName = parts[0];
                String[] cmdArgs = parts.length > 1 ? parts[1].split("\\s+") : new String[0];
                commandManager.execute(cmdName, cmdArgs);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + args[0]);
        } catch (IOException e) {
            System.out.println("Ошибка чтения скрипта: " + e.getMessage());
        }
    }

    @Override
    public String getDescription() { return "выполнить скрипт из файла"; }
}