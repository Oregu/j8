package mixin;

import mixin.speed.IFastCar;
import mixin.speed.ISlowCar;
import mixin.steer.IFastSteerCar;
import mixin.steer.ISlowSteerCar;

public class Main {

    private static class VeryFastCar extends ACar implements IFastCar, IFastSteerCar {}
    private static class VerySlowCar extends ACar implements ISlowCar, ISlowSteerCar {}

    public static int main(String[] args) {

        ICar car1 = new VeryFastCar();
        ICar car2 = new VerySlowCar();

        return 0;
    }
}
