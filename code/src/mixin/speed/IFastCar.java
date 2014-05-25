package mixin.speed;

import mixin.ICar;

public interface IFastCar extends ICar {

    default void move(int speed) {
        location(location() + 2*speed);
    }
}
