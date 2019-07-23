package hw8.enums;

public enum Colors {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
