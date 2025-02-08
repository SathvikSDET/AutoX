package core;

public enum LocatorType {
    XPATH, CSS, ID;

    public static LocatorType fromString(String type) {
        return switch (type.toLowerCase()) {
            case "xpath" -> XPATH;
            case "css" -> CSS;
            case "id" -> ID;
            default -> throw new IllegalArgumentException("Invalid locator type: " + type);
        };
    }
}
