import java.util.Date;
import java.util.Scanner;

public class MailOrder extends Order{

    private Date postDate;

    public MailOrder(Customer customer, Date date) {
        super(customer, date);
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public void CreateOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the post date:(dd/mm/yyyy)");
        String postDateStr = sc.nextLine();
        Date postDate = new Date(postDateStr);
        setPostDate(postDate);
        System.out.println("Please enter the item/s you want to add details.");
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
    }

    @Override
    public String toString() {
        return super.toString() + "\nPost Date: " + postDate;
    }
}
