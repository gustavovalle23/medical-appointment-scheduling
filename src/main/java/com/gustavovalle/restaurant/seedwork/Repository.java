package com.gustavovalle.restaurant.seedwork;

public interface Repository <Entity> {
    Entity save(Entity entity);
}
