package solvd.laba.enums;

public enum OrderStatus {

    PENDING("Order placed. In preparation."),
    CONFIRMED("Order confirmed, preparing for shipment."),
    DELIVERED("Order delivered to the customer");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return this.description;
    }

    public boolean hasBeenDelivered(){
        return this!=DELIVERED;
    }


}
