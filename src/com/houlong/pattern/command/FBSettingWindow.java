package com.houlong.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houlong on 2017/6/19.
 */
public class FBSettingWindow {
    private String title;
    private List<FunctionButton> functionButtons;

    public FBSettingWindow(String title) {
        this.title = title;
        this.functionButtons = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void addFunctionButtons(FunctionButton fb) {
        functionButtons.add(fb);
    }

    public void removeFunctionButton(FunctionButton fb) {
        functionButtons.remove(fb);
    }

    public void display(){
        System.out.println("显示窗口:" + this.title);
        System.out.println("显示功能键:");
        for (FunctionButton bf : functionButtons) {
            System.out.println(bf.getName());
        }
        System.out.println("------------------------------");
    }
}
