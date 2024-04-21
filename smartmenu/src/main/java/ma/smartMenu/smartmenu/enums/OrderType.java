package ma.smartMenu.smartmenu.enums;

public enum OrderType {
    IN_TABLE("In table"),
    ONLINE("Online Order"),
    IN_STORE("In-Store Order");

    private final String displayName;

    OrderType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
