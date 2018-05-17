package com.houlong.pattern.command;

/**
 * 具体命令类
 */
public class HelpCommand extends Command {

    private HelpHandler helpHandler;

    public HelpCommand() {
        helpHandler = new HelpHandler();
    }

    @Override
    public void execute() {
        helpHandler.display();
    }
}
