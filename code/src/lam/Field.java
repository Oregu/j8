package lam;

public class Field {
    private String name;
    private boolean enabled;

    public Field(String name) {
        this(name, false);
    }

    public Field(String name, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public static Field create(String name) {
        return new Field(name, false);
    }
}
