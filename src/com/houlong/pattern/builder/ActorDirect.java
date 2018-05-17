package com.houlong.pattern.builder;

/**
 *
 * 指挥者
 */
public class ActorDirect {

    public Actor construct(ActorBuilder ab)
    {
        Actor actor;
        ab.builderType();
        ab.builderSex();
        ab.builderFace();
        ab.builderCostume();
        ab.builderHairStyle();
        actor=ab.createActor();
        return actor;
    }
}
