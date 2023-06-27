package corejava11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankChatBot {
	private boolean online;
    private Scanner scanner;
    private List<User> users;
    private Admin admin;
    private AdminFeatures adminFeatures;

    public BankChatBot() {
        online = true;
        scanner = new Scanner(System.in);
        users = new ArrayList<>();
        admin = new Admin("admin", "admin123");
        adminFeatures = new AdminFeatures(users);
    }

    public void start() {
        System.out.println("Welcome to the Bank Chat Bot!");
        User user1 = new User(1, "password123", "Tunde S A", "41 raise St, Houston Tx 77777", "tundesa@gmail.com", "1234567890", 1000.0);
        users.add(user1);

        User user2 = new User(2, "password2", "Jane Smith", "456 Elm St, Brooklyn Ny 12154", "janesmith@gmail.com", "9876543210", 500.0);
        users.add(user2);

        
        while (online) {
            System.out.println("\nPlease choose your role:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    online = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Have a good day. Thank you for using Bank Chat Bot.");
    }

    private void adminLogin() {
        System.out.print("Please enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

        if (admin.login(username, password)) {
            adminFeatures.start();
        } else {
            System.out.println("Invalid username or password. Login failed.");
        }
    }

    private void userLogin() {
        System.out.print("Enter your user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User user = getUserById(userId);
        if (user != null && user.login(password)) {
            userFeatures(user);
        } else {
            System.out.println("Invalid user ID or password. Login failed.");
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

    private void userFeatures(User user) {
        System.out.println("\nWelcome, User ID: " + user.getId() + "!");
        System.out.println("Name: " + user.getName());
        System.out.println("Address: " + user.getAddress());
        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View Balance");
            System.out.println("2. Log Off");
            System.out.print("Enter your choice (1 or 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    user.viewBalance();
                    break;
                case 2:
                    loggedIn = false;
                    System.out.println("\nLogged out!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
