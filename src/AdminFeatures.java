package corejava11;

import java.util.List;
import java.util.Scanner;

public class AdminFeatures {

	  private List<User> users;
	    private Scanner scanner;

	    public AdminFeatures(List<User> users) {
	        this.users = users;
	        scanner = new Scanner(System.in);
	    }

	    public void start() {
	        boolean loggedIn = true;

	        while (loggedIn) {
	            System.out.println("\nAdmin Menu:");
	            System.out.println("1. List all users");
	            System.out.println("2. Search user by ID");
	            System.out.println("3. Add a new user");
	            System.out.println("4. Edit user information");
	            System.out.println("5. Log Off");
	            System.out.print("Enter your choice (1-5): ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    listAllUsers();
	                    break;
	                case 2:
	                    System.out.print("Enter user ID: ");
	                    int userId = scanner.nextInt();
	                    scanner.nextLine();
	                    searchUserById(userId);
	                    break;
	                case 3:
	                    addUser();
	                    break;
	                case 4:
	                    System.out.print("Enter user ID: ");
	                    int editUserId = scanner.nextInt();
	                    scanner.nextLine();
	                    editUser(editUserId);
	                    break;
	                case 5:
	                    loggedIn = false;
	                    System.out.println("\nLogged out from admin account!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }

	    private void listAllUsers() {
	        System.out.println("\nAll Users:");

	        for (User user : users) {
	            System.out.println("User ID: " + user.getId());
	            System.out.println("Name: " + user.getName());
	            System.out.println("Address: " + user.getAddress());
	            System.out.println("Email: " + user.getEmail());
	            System.out.println("Phone Number: " + user.getPhoneNumber());
	            System.out.println("Balance: $" + user.getBalance());
	            System.out.println("--------------------");
	        }
	    }

	    private void searchUserById(int userId) {
	        User user = getUserById(userId);

	        if (user != null) {
	            System.out.println("\nUser Found:");
	            System.out.println("User ID: " + user.getId());
	            System.out.println("Name: " + user.getName());
	            System.out.println("Address: " + user.getAddress());
	            System.out.println("Email: " + user.getEmail());
	            System.out.println("Phone Number: " + user.getPhoneNumber());
	            System.out.println("Balance: $" + user.getBalance());
	        } else {
	            System.out.println("\nUser not found with ID: " + userId);
	        }
	    }

	    private void addUser() {
	        System.out.print("Enter user ID: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();

	        System.out.print("Enter user password: ");
	        String password = scanner.nextLine();

	        System.out.print("Enter user name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter user address: ");
	        String address = scanner.nextLine();

	        System.out.print("Enter user email: ");
	        String email = scanner.nextLine();

	        System.out.print("Enter user phone number: ");
	        String phoneNumber = scanner.nextLine();

	        System.out.print("Enter user balance: $");
	        double balance = scanner.nextDouble();
	        scanner.nextLine();

	        User newUser = new User(id, password, name, address, email, phoneNumber, balance);
	        users.add(newUser);

	        System.out.println("\nUser added successfully!");
	    }

	    private void editUser(int userId) {
	        User user = getUserById(userId);

	        if (user != null) {
	            System.out.println("\nEditing User: " + user.getName());
	            System.out.println("1. Edit Address");
	            System.out.println("2. Edit Email");
	            System.out.println("3. Edit Phone Number");
	            System.out.println("4. Edit Balance");
	            System.out.println("5. Cancel");
	            System.out.print("Enter your choice (1-5): ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter new address: ");
	                    String address = scanner.nextLine();
	                    user.setAddress(address);
	                    System.out.println("\nAddress updated successfully!");
	                    break;
	                case 2:
	                    System.out.print("Enter new email: ");
	                    String email = scanner.nextLine();
	                    user.setEmail(email);
	                    System.out.println("\nEmail updated successfully!");
	                    break;
	                case 3:
	                    System.out.print("Enter new phone number: ");
	                    String phoneNumber = scanner.nextLine();
	                    user.setPhoneNumber(phoneNumber);
	                    System.out.println("\nPhone number updated successfully!");
	                    break;
	                case 4:
	                    System.out.print("Enter new balance: $");
	                    double balance = scanner.nextDouble();
	                    scanner.nextLine();
	                    user.setBalance(balance);
	                    System.out.println("\nBalance updated successfully!");
	                    break;
	                case 5:
	                    System.out.println("\nEditing cancelled!");
	                    break;
	                default:
	                    System.out.println("\nInvalid choice. Editing cancelled!");
	                    break;
	            }
	        } else {
	            System.out.println("\nUser not found with ID: " + userId);
	        }
	    }

	    private User getUserById(int userId) {
	        for (User user : users) {
	            if (user.getId() == userId) {
	                return user;
	            }
	        }
	        return null;
	    }
}
