package com.gustavovalle.restaurant.seedwork;


public interface UseCase<Input, Output> {
    Output execute(Input anIn) throws Exception;
}
