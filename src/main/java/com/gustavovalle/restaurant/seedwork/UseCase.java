package com.gustavovalle.restaurant.seedwork;


public interface UseCase<Input, Output> {
    public Output execute(Input anIn);
}