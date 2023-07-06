import java.util.Date;
import java.util.ArrayList;

// Order abstract class
public abstract class Order implements Comparable<Order> {
    private int id;
    private Customer customer;
    private Date date;
    private int itemCount;
    private ArrayList<OrderItem> orderItems;
    private static int orderSequential = 1; // Used to generate unique order IDs

    public Order(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
        this.id = orderSequential++;
        this.itemCount = 0;
        this.orderItems = new ArrayList<OrderItem>();
    }

    public abstract void CreateOrder();

    @Override
    public int compareTo(Order o) {
        // Sort by Date
        return this.date.compareTo(o.date);
    }

    public Date getOrderDate() {
        return this.date;
    }

    public int getOrderID() {
        return this.id;
    }

    public double getOrderTotal() {
        double total = 0;
        for (int i = 0; i < orderItems.size(); i++) {
            total += orderItems.get(i).subTotal();
        }
        return total;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void printOrder() {
        System.out.println(this.toString());
    }

    public void printOrderItems() {
        for (int i = 0; i < orderItems.size(); i++) {
            System.out.println(orderItems.get(i).toString());
        }
    }

    @Override
    public String toString() {
        String items = "";
        for (int i = 0; i < orderItems.size(); i++) {
            items += orderItems.get(i).toString() + "\n";
        }
        return "Order ID: " + id +
                ", Date: " + date +
                ", Customer: " + customer.toString() +
                ", Items Ordered:\n" + items +
                "Item Count: " + orderItems.size();
    }
}
