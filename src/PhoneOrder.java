import java.util.Date;
import java.util.Scanner;

public class PhoneOrder extends Order{
    private int callDuration;

    private String customerRepresentative;

    public PhoneOrder(Customer customer, Date date) {
        super(customer, date);
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCustomerRepresentative(String customerRepresentative) {
        this.customerRepresentative = customerRepresentative;
    }

    public String getCustomerRepresentative() {
        return customerRepresentative;
    }

    @Override
    public void CreateOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the customer representative:");
        String name = sc.nextLine();
        setCustomerRepresentative(name);
        System.out.println("Please enter the item details:");
        int choice = 0;
        while(choice != 2){
            System.out.println("Please enter the product ID:");
            long productID = sc.nextLong();
            sc.nextLine(); // Consume the newline character
            System.out.println("Please enter the description:");
            String description = sc.nextLine();
            System.out.println("Please enter the price:");
            double price = sc.nextDouble();
            System.out.println("Please enter the quantity:");
            int quantity = sc.nextInt();
            OrderItem orderItem = new OrderItem(productID, description, price, quantity);
            super.getOrderItems().add(orderItem);
            System.out.println("Do you want to add another item? 1. Yes 2. No");
            choice = sc.nextInt();
        }
        System.out.println("Please enter the call duration:");
        int callDuration = sc.nextInt();
        setCallDuration(callDuration);
    }

    @Override
    public String toString() {
        return super.toString() + "\nCall Duration: " + callDuration + ", Customer Representative: " + customerRepresentative;
    }
}
