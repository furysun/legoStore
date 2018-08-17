package com.legoStore.controller.command;

import java.util.Map;

public class CommandContainer {
    private Map<String, Command> commands;

    private volatile static CommandContainer instance;

    private CommandContainer() {
    }

    public static CommandContainer getInstance() {
        if (instance == null) {
            synchronized (CommandContainer.class) {
                if (instance == null) {
                    instance = new CommandContainer();
                }
            }
        }
        return instance;
    }

    public void setCommands(Map<String, Command> commands) {
        this.commands = commands;
    }

    public Command getCommand(String commandName){
        return commands.get(commandName);
    }
}
