package com.houlong.pattern.mediator;

/**
 * 抽象同事类
 * 定义了同事类共有的方法，并声明一些抽象方法供子类实现。同时维持一个抽象中介者的引用。
 */
abstract class Component {
    private Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    //转发调用
    public void changed() {
        mediator.componentChanged(this);
    }

    public abstract void update();
}
