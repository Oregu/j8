package mixin;

public abstract class ACar implements ICar {
    private int location;

    @Override
    public int location() {
        return location;
    }

    @Override
    public void location(int loc) {
        location = loc;
    }
}
