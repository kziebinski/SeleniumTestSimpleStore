package model;

public class Product {

    private float value;
    private float quantity;

    public Product(float value, float quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public float getValue() {
        return value;
    }

    public float getQuantity() {
        return quantity;
    }
}
