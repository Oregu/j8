package mixin.steer;

import mixin.ICar;

public interface ISlowSteerCar extends ICar {

    default void steer(float delta) {
        location(location() + (int)(0.5*delta));
    }
}
