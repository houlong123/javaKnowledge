package com.houlong.pattern.command;

/**
 * Created by houlong on 2017/6/19.
 */
public class MinimizeCommand extends Command {

    private WindowHandler handler;

    public MinimizeCommand() {
        handler = new WindowHandler();
    }

    @Override
    public void execute() {
        handler.minimize();
    }
}
