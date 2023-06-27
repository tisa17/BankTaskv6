package corejava11;

public class User {
	
	 private int id;
	    private String password;
	    private String name;
	    private String address;
	    private String email;
	    private String phoneNumber;
	    private double balance;

	    public User(int id, String password, String name, String address, String email, String phoneNumber, double balance) {
	        this.id = id;
	        this.password = password;
	        this.name = name;
	        this.address = address;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.balance = balance;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }

	    public void viewBalance() {
	        System.out.println("Your balance is: $" + balance);
	    }
    public boolean login(String password) {
        return this.password.equals(password);
    }

}
