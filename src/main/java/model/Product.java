package model;

public class Product {

    private float value;
    private float quantity;
    private String name;

    public Product(float value, float quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public Product(float value, String name) {
        this.value = value;
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public float getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
