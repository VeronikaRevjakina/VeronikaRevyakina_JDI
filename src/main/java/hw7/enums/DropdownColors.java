package hw7.enums;

public enum DropdownColors {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    final String color;

    DropdownColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
