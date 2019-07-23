package hw8.enums;

public enum Vegetables {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");

    final String vegetable;

    Vegetables(String vegetable) {
        this.vegetable = vegetable;
    }

    public String getVegetable() {
        return vegetable;
    }
}
