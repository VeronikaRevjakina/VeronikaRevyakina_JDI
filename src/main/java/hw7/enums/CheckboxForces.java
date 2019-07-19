package hw7.enums;

public enum CheckboxForces {
    WATER("Water"),
    EARTH("Earth"),
    FIRE("Fire"),
    WIND("Wind");

    final String force;

    CheckboxForces(String force) {
        this.force = force;
    }

    public String getForce() {
        return force;
    }

}
