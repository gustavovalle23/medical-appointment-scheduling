package com.gustavovalle.restaurant.seedwork;

import java.util.Optional;

public interface Repository <Entity> {
    Optional<Entity> save(Entity entity);
}
