package model;

import enums.CommandEnum;

public class CommandInput {
    private CommandEnum command;

    public CommandInput(CommandEnum command) {
        this.command = command;
    }

    public CommandEnum getCommand() {
        return command;
    }
}
