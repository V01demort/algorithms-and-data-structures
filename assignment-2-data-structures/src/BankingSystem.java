import java.util.Scanner;

public class BankingSystem {

    static class BankAccount {
        String accountNumber;
        String username;
        int balance;

        public BankAccount(String accountNumber, String username, int balance) {
            this.accountNumber = accountNumber;
            this.username = username;
            this.balance = balance;
        }
    }

    static BankAccount[] accounts = new BankAccount[100];
    static int accCount = 0;

    static String[] transactionHistory = new String[100];
    static int historyTop = -1;

    static String[] billQueue = new String[100];
    static int billFront = 0, billRear = 0;

    static BankAccount[] accountRequests = new BankAccount[100];
    static int reqFront = 0, reqRear = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        accounts[accCount++] = new BankAccount("ACC001", "Ali", 150000);
        accounts[accCount++] = new BankAccount("ACC002", "Sara", 220000);

        enqueueBill("Electricity Bill");
        enqueueBill("Internet Bill");
        enqueueBill("Mobile Phone Bill");

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1 – Enter Bank");
            System.out.println("2 – Enter ATM");
            System.out.println("3 – Admin Area");
            System.out.println("4 – Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                bankMenu(scanner);
            } else if (choice == 2) {
                atmMenu(scanner);
            } else if (choice == 3) {
                adminMenu(scanner);
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    static void bankMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Request account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Back");

            int b = scanner.nextInt();
            scanner.nextLine();

            if (b == 1) {
                System.out.print("Account number: ");
                String num = scanner.nextLine();
                System.out.print("Username: ");
                String user = scanner.nextLine();
                System.out.print("Balance: ");
                int bal = scanner.nextInt();
                scanner.nextLine();

                if (bal < 0 || reqRear == accountRequests.length) {
                    System.out.println("Invalid balance or request queue full");
                    continue;
                }
                accountRequests[reqRear++] = new BankAccount(num, user, bal);
                System.out.println("Request added");

            } else if (b == 2) {
                depositOrWithdraw(scanner, true);
            } else if (b == 3) {
                depositOrWithdraw(scanner, false);
            } else break;
        }
    }

    static void atmMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== ATM ===");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Back");

            int a = scanner.nextInt();
            scanner.nextLine();

            if (a == 1) {
                System.out.print("Username: ");
                String user = scanner.nextLine();
                BankAccount acc = findAccount(user);

                if (acc != null) {
                    System.out.println("Balance: " + acc.balance);
                } else {
                    System.out.println("Not found");
                }

            } else if (a == 2) {
                depositOrWithdraw(scanner, false);
            } else break;
        }
    }

    static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== ADMIN ===");
            System.out.println("1. View requests");
            System.out.println("2. Process request");
            System.out.println("3. View bills");
            System.out.println("4. Process bill");
            System.out.println("5. Back");

            int ad = scanner.nextInt();
            scanner.nextLine();

            if (ad == 1) {
                for (int i = reqFront; i < reqRear; i++) {
                    System.out.println(accountRequests[i].username);
                }

            } else if (ad == 2) {
                if (reqFront < reqRear) {
                    if (accCount == accounts.length) {
                        System.out.println("Account limit reached");
                        continue;
                    }
                    accounts[accCount++] = accountRequests[reqFront++];
                    System.out.println("Account added");
                }

            } else if (ad == 3) {
                for (int i = billFront; i < billRear; i++) {
                    System.out.println(billQueue[i]);
                }

            } else if (ad == 4) {
                if (billFront < billRear) {
                    System.out.println("Processing: " + billQueue[billFront++]);
                }

            } else break;
        }
    }

    static void depositOrWithdraw(Scanner scanner, boolean isDeposit) {
        System.out.print("Username: ");
        String user = scanner.nextLine();

        BankAccount acc = findAccount(user);
        if (acc == null) {
            System.out.println("Not found");
            return;
        }

        System.out.print("Amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Amount must be positive");
            return;
        }

        if (isDeposit) {
            if (amount > Integer.MAX_VALUE - acc.balance) {
                System.out.println("Balance limit exceeded");
                return;
            }
            acc.balance += amount;
            pushHistory("Deposit " + amount);
        } else {
            if (amount > acc.balance) {
                System.out.println("Not enough money");
                return;
            }
            acc.balance -= amount;
            pushHistory("Withdraw " + amount);
        }

        System.out.println("New balance: " + acc.balance);
    }

    static BankAccount findAccount(String username) {
        for (int i = 0; i < accCount; i++) {
            if (accounts[i].username.equals(username)) {
                return accounts[i];
            }
        }
        return null;
    }

    static void pushHistory(String text) {
        if (historyTop + 1 < transactionHistory.length) {
            transactionHistory[++historyTop] = text;
        }
    }

    static void enqueueBill(String bill) {
        billQueue[billRear++] = bill;
    }
}
