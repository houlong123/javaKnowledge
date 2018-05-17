package com.houlong.pattern.command;

/**
 * 调用者
 */
public class FunctionButton {
    private Command command;
    String name;

    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public  void onClick() {
        System.out.print("点击功能键:");
        command.execute();
    }
}
