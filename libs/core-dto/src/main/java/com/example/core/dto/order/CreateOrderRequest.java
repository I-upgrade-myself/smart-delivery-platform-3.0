package main.java.com.example.core.dto.order;


public class CreateOrderRequest {
    private String customerName;
    private String product;
    private int quantity;

    // Getters & Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
