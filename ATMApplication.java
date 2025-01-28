class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        this.balance=initialBalance;

    }
    public void deposit(double amount){
        if(amount>0){
            balance=balance+amount;
            System.out.println("Sucessfully Deposited ₹" +amount);

        }
        else{
            System.out.println("INVALID Deposit Amount :(");

        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew ₹" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
        return false;
    }
    public double getBalance() {
        return balance;
    }
}
class ATM{
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void start() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> { // Withdraw
                    System.out.print("Enter the amount to withdraw: ₹");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                }
                case 2 -> { // Deposit
                    System.out.print("Enter the amount to deposit: ₹");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                }
                case 3 -> { // Check Balance
                    System.out.println("Current balance: ₹" + account.getBalance());
                }
                case 4 -> { // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

public class ATMApplication {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000.0);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
    }
