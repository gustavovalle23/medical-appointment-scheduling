package com.gustavovalle.medicalappointment.seedwork;


public interface UseCase<Input, Output> {
    public Output execute(Input anIn);
}