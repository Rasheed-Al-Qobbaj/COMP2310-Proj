import java.util.ArrayList;

public class Customer {
    private long customerID;
    private String name;
    private String address;
    private ArrayList<Order> orderList;
    public Customer(long id, String name, String address) {
        this.customerID = id;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public long getCustomerID() {
        return customerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private void sortOrders() {
        for (int i = 0; i < orderList.size(); i++) {
            for (int j = i + 1; j < orderList.size(); j++) {
                if (orderList.get(i).compareTo(orderList.get(j)) > 0) {
                    Order temp = orderList.get(i);
                    orderList.set(i, orderList.get(j));
                    orderList.set(j, temp);
                }
            }
        }
    }
    public void displayOrderList() {
        sortOrders();
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i).toString());
            System.out.println(""); // Empty line
        }
    }

    public void addOrder(Order order) {
        if (orderList == null) {
            orderList = new ArrayList<Order>();
        }
        orderList.add(order);
    }

    @Override
    public String toString() {
        return ", Name: " + name + ", Address: " + address;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Customer) {
            Customer c = (Customer) obj;
            return this.customerID == c.customerID;
        }
        return false;
    }
}
