import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println(" Task 1 (LinkedList)");
            System.out.println(" Task 2 (Deposit & Withdraw)");
            System.out.println(" Task 3 (Stack History)");
            System.out.println(" Task 4 (Queue Bills)");
            System.out.println(" Task 5 (Queue Admin)");
            System.out.println(" Task 6 (Array)");
            System.out.println("----------------------------------------");
            System.out.println(" Part 3 (Mini Banking Menu)");
            System.out.println("0 - Выход");
            System.out.print("Выберите пункт: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: runTask1(); break;
                case 2: runTask2(); break;
                case 3: runTask3(); break;
                case 4: runTask4(); break;
                case 5: runTask5(); break;
                case 6: runTask6(); break;
                case 7: runPart3BankingMenu(); break;
                case 0: System.out.println("До свидания!"); return;
                default: System.out.println("Неверный выбор!");
            }
        }
    }
    static void runTask1() {
        System.out.println("\n--- TASK 1 ---");
        LinkedList<BankAccount> accounts = new LinkedList<>();
        accounts.add(new BankAccount(1, "Ali", 150000));
        accounts.add(new BankAccount(2, "Sara", 220000));

        System.out.println("Account added successfully");
        System.out.println("Accounts List:");
        for (BankAccount acc : accounts) {
            System.out.println(acc.toString());
        }
    }

    static void runTask2() {
        System.out.println("\n--- TASK 2 ---");
        LinkedList<BankAccount> accounts = new LinkedList<>();
        accounts.add(new BankAccount(1, "Ali", 150000));

        System.out.print("Enter username: ");
        String name = scanner.nextLine();

        if (name.equalsIgnoreCase("Ali")) {
            System.out.print("Deposit: ");
            double amount = scanner.nextDouble();
            accounts.get(0).deposit(amount);
            System.out.println("New balance: " + accounts.get(0).balance);
        }
    }

    static void runTask3() {
        System.out.println("\n--- TASK 3 ---");
        Stack<String> history = new Stack<>();

        history.push("Deposit 50000 to Ali");
        System.out.println("Deposit 50000 to Ali");

        history.push("Withdraw 20000 from Ali");
        System.out.println("Withdraw 20000 from Ali");

        System.out.println("Last transaction: " + history.peek());
        System.out.println("Undo -> " + history.pop() + " removed");
    }

    static void runTask4() {
        System.out.println("\n--- TASK 4 ---");
        Queue<String> billQueue = new LinkedList<>();

        billQueue.add("Electricity Bill");
        System.out.println("Added: Electricity Bill");

        billQueue.add("Internet Bill");
        System.out.println("Added: Internet Bill");

        System.out.println("Processing: " + billQueue.poll());
        System.out.println("Remaining: " + billQueue.peek());
    }

    static void runTask5() {
        System.out.println("\n--- TASK 5 ---");
        Queue<String> accountRequests = new LinkedList<>();
        LinkedList<BankAccount> approvedAccounts = new LinkedList<>();

        accountRequests.add("John");
        System.out.println("User submits request -> Added 'John' to queue.");
        System.out.println("Pending requests: " + accountRequests);

        System.out.println("Admin processing...");
        String newName = accountRequests.poll();
        approvedAccounts.add(new BankAccount(3, newName, 0));

        System.out.println("Account created! Main list now contains: " + approvedAccounts);
    }

    static void runTask6() {
        System.out.println("\n--- TASK 6 ---");
        BankAccount[] fixedArray = new BankAccount[3];
        fixedArray[0] = new BankAccount(1, "Ali", 150000);
        fixedArray[1] = new BankAccount(2, "Sara", 220000);
        fixedArray[2] = new BankAccount(3, "Max", 50000);

        System.out.println("Physical Array Contents:");
        for (int i = 0; i < fixedArray.length; i++) {
            System.out.println(fixedArray[i].toString());
        }
    }

    static LinkedList<BankAccount> globalAccounts = new LinkedList<>();
    static Stack<String> globalHistory = new Stack<>();
    static Queue<String> globalBills = new LinkedList<>();
    static Queue<String> globalRequests = new LinkedList<>();

    static void runPart3BankingMenu() {
        globalAccounts.add(new BankAccount(1, "Ali", 150000));
        globalAccounts.add(new BankAccount(2, "Sara", 220000));

        while (true) {
            System.out.println("\n=== MINI BANKING MENU (PART 3) ===");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Return to Main Menu");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\n-- BANK --\n1. Submit Request\n2. Deposit\n3. Withdraw");
                System.out.print("Choice: ");
                int bChoice = scanner.nextInt();
                scanner.nextLine();
                if (bChoice == 1) {
                    System.out.print("Name: ");
                    globalRequests.add(scanner.nextLine());
                    System.out.println("Sent to Admin!");
                } else if (bChoice == 2) {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amt = scanner.nextDouble();
                    for (BankAccount a : globalAccounts) if (a.username.equalsIgnoreCase(name)) a.deposit(amt);
                    globalHistory.push("Deposit " + amt + " to " + name);
                } else if (bChoice == 3) {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amt = scanner.nextDouble();
                    for (BankAccount a : globalAccounts) if (a.username.equalsIgnoreCase(name)) a.withdraw(amt);
                    globalHistory.push("Withdraw " + amt + " from " + name);
                }
            }
            else if (choice == 2) {
                System.out.println("\n-- ATM --");
                System.out.print("Name: ");
                String name = scanner.nextLine();
                for (BankAccount a : globalAccounts) {
                    if (a.username.equalsIgnoreCase(name)) {
                        System.out.println("Balance: " + a.balance);
                        System.out.print("Withdraw amount: ");
                        a.withdraw(scanner.nextDouble());
                        globalHistory.push("ATM Withdraw from " + name);
                    }
                }
            }
            else if (choice == 3) {
                System.out.println("\n-- ADMIN --");
                System.out.println("1. Process Queue\n2. View Accounts");
                int aChoice = scanner.nextInt();
                if (aChoice == 1 && !globalRequests.isEmpty()) {
                    String req = globalRequests.poll();
                    globalAccounts.add(new BankAccount(3, req, 0));
                    System.out.println("Approved: " + req);
                } else if (aChoice == 2) {
                    for (BankAccount a : globalAccounts) System.out.println(a);
                }
            }
            else if (choice == 4) {
                break;
            }
        }
    }
}