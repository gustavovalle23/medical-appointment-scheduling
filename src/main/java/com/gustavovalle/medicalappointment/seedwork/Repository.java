package com.gustavovalle.medicalappointment.seedwork;

import java.util.Optional;

public interface Repository <Entity> {
    Optional<Entity> save(Entity entity);
}
