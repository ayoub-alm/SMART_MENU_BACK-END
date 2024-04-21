package ma.smartMenu.smartmenu.enums;

public enum OrderState {
    CREATED("Created"),
    PROCESSING("Processing"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELED("Canceled");

    private final String displayName;

    OrderState(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}


