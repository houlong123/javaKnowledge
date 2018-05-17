package com.houlong.pattern.command;

/**
 * 命令模式
 */
public class Client {

    public static void main(String[] args) {
        FBSettingWindow window = new FBSettingWindow("功能键设置");

        FunctionButton functionButton, functionButton1;
        functionButton = new FunctionButton("功能键1");
        functionButton1 = new FunctionButton("功能键2");

        Command command, command1;
        command = new MinimizeCommand();
        command1 = new HelpCommand();

        //将命令对象注入功能键
        functionButton.setCommand(command);
        functionButton1.setCommand(command1);

        window.addFunctionButtons(functionButton);
        window.addFunctionButtons(functionButton1);
        window.display();

        //调用功能键业务方法
        functionButton.onClick();
        functionButton1.onClick();
    }
}
