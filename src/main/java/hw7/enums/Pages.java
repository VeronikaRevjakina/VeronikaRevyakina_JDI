package hw7.enums;

public enum Pages {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");

    final String name;

    Pages(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
