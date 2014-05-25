package mixin.speed;

import mixin.ICar;

public interface ISlowCar extends ICar {

    default void move(int speed) {
        location(location() + (int)(0.5*speed));
    }
}
