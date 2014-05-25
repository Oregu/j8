package mixin.steer;

import mixin.ICar;

public interface IFastSteerCar extends ICar {

    default void steer(float delta) {
        location(location() + (int)(2*delta));
    }
}
