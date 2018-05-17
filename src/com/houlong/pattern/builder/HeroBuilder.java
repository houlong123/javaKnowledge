package com.houlong.pattern.builder;

/**
 *
 */
public class HeroBuilder extends ActorBuilder {

    public void builderSex() {
        actor.setSex("男");
    }
    public void builderType() {
        actor.setType("英雄");
    }
    public void builderFace() {
        actor.setFace("英俊");
    }
    public void builderHairStyle() {
        actor.setHairstyle("飘逸");
    }
    public void builderCostume() {
        actor.setCostume("盔甲");
    }

}
