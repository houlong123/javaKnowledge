package com.houlong.pattern.mediator;

/**
 *
 * 抽象中介者
 * 定义一个接口，用于与各个同事对象之间进行通信
 *
 */
abstract class Mediator {
    public abstract void componentChanged(Component c);
}
