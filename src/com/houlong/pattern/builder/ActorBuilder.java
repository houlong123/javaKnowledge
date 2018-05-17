package com.houlong.pattern.builder;

/**
 * 抽象建造者
 */
abstract class ActorBuilder {

    protected static Actor actor = new Actor();

    public abstract void builderSex();
    public abstract void builderType();
    public abstract void builderFace();
    public abstract void builderHairStyle();
    public abstract void builderCostume();

    public Actor createActor() {
        return actor;
    }

    /**
     * 缺省Direct时，可以在抽象建造者中添加一个用于创建产品的静态方法
     * @param ab
     * @return
     */
    public static Actor builderActor(ActorBuilder ab) {
        ab.builderType();
        ab.builderSex();
        ab.builderFace();
        ab.builderCostume();
        ab.builderHairStyle();
        return actor;
    }

}
