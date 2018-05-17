package com.houlong.pattern.abstractFactory;

/**
 * concrete factory
 */
public class SummerSkinFactory implements SkinFactory {

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public Button createButton() {
        return new SummerButton();
    }
}
