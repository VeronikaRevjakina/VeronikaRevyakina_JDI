package hw7.enums;

public enum RadioMetals {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String metal;

    RadioMetals(String metal) {
        this.metal = metal;
    }

    public String getMetal() {
        return metal;
    }
}
