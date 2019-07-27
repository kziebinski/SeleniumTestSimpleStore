package model;

public class Product {

    private static float value;
    private static float totalValue;
    private static float quantity;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getTotalValue() {
        return value * quantity;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
}
