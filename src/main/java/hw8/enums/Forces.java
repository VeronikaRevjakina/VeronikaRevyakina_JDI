package hw8.enums;

public enum Forces {
    WATER("Water"),
    EARTH("Earth"),
    FIRE("Fire"),
    WIND("Wind");

    final String force;

    Forces(String force) {
        this.force = force;
    }

    public String getForce() {
        return force;
    }

}
