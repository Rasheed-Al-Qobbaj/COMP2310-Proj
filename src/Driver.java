import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Create a new customer list
        ArrayList<Customer> customerList = new ArrayList<Customer>();

        System.out.println("Welcome to the Order Management System");
        // 2) Execute the user's choice and then continue till they quit
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (choice != 4) {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Add a customer
                    addCustomer(customerList);
                    break;
                case 2:
                    // Make a new order
                    makeOrder(customerList);
                    break;
                case 3:
                    // Display customer's orders
                    displayCustomerOrders(customerList);
                    break;
                case 4:
                    // Quit
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Please select an option (1-4):");
        System.out.println("1) Add a customer");
        System.out.println("2) Make a new Order");
        System.out.println("3) Display Customer’s Orders");
        System.out.println("4) Quit");
    }

    private static void addCustomer(ArrayList<Customer> customerList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the customer's ID:");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.println("Please enter the customer's name:");
        String name = sc.nextLine();
        System.out.println("Please enter the customer's address:");
        String address = sc.nextLine();

        Customer c = new Customer(id, name, address);
        boolean found = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).equals(c)) {
                found = true;
                System.out.println("Customer already exists!");
                return;
            }
        }
        if (!found) {
            customerList.add(c);
            System.out.println("Customer added successfully!");
        }
    }

    private static void makeOrder(ArrayList<Customer> customerList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the customer's ID:");
        int id = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerID() == id) {
                found = true;
                System.out.println("Please enter the order type (1 for Mail Order, 2 for Phone Order):");
                boolean valid = false;
                int orderType = sc.nextInt();
                while (!valid) {
                    if (orderType == 1) {
                        valid = true;
                        Date date = new Date();
                        MailOrder m = new MailOrder(customerList.get(i), date);
                        m.CreateOrder();
                        customerList.get(i).addOrder(m);
                        m.printOrder();
                        //System.out.println(", Post Date: " + m.getPostDate());
                    } else if (orderType == 2) {
                        valid = true;
                        Date date = new Date();
                        PhoneOrder p = new PhoneOrder(customerList.get(i), date);
                        p.CreateOrder();
                        customerList.get(i).addOrder(p);
                        p.printOrder();
                        //System.out.println(", Customer Representative: " + p.getCustomerRepresentative() + ", Call Duration: " + p.getCallDuration());
                    } else {
                        System.out.println("Invalid order type!");
                    }
                }
                return;
            }
        }

        if (!found) {
            System.out.println("Customer not found! Please Choose:");
            System.out.println("1- Would you like to enter a different customer ID?");
            System.out.println("2- Would you like to create a new customer?");
            System.out.println("3- Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    makeOrder(customerList);
                    break;
                case 2:
                    addCustomer(customerList);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

        }
    }

    private static void displayCustomerOrders(ArrayList<Customer> customerList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the customer's ID:");
        int id = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerID() == id) {
                found = true;
                customerList.get(i).displayOrderList();
                return;
            }
        }
        if (!found) {
            System.out.println("Customer not found!");
        }
    }



}