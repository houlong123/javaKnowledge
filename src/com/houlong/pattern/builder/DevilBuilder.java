package com.houlong.pattern.builder;

/**
 *
 */
public class DevilBuilder extends ActorBuilder {

    public void builderSex() {
        actor.setSex("男");
    }
    public void builderType() {
        actor.setType("恶魔");
    }
    public void builderFace() {
        actor.setFace("丑陋");
    }
    public void builderHairStyle() {
        actor.setHairstyle("光头");
    }
    public void builderCostume() {
        actor.setCostume("恶魔之光");
    }

}
