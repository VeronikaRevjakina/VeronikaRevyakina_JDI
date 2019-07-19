package hw7.enums;

public enum Menu {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");

    final String name;

    Menu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
