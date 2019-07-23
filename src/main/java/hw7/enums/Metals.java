package hw7.enums;

public enum Metals {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    final String metal;

    Metals(String metal) {
        this.metal = metal;
    }

    public String getMetal() {
        return metal;
    }
}
