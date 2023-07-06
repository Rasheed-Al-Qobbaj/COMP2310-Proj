public class OrderItem {
    private long productID;
    private String description;
    private double price;
    private int quantity;

    public OrderItem(long productID, String description, double price, int quantity) {
        this.productID = productID;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public double subTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + productID + ", Description: " + description + ", Price: " + price + ", Quantity: "
                + quantity + ", Subtotal: " + subTotal();
    }
}
