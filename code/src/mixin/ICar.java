package mixin;

public interface ICar {
    void move(int speed);
    void steer(float delta);

    int location();
    void location(int loc);
}
