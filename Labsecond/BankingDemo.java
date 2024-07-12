class BankAccount {
    private double balance;
    private final Object lock = new Object();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized method
    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing " + amount);
        balance += amount;
        System.out.println("New balance after deposit: " + balance);
    }

    // Method with synchronized block
    public void withdraw(double amount) {
        synchronized (lock) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
                balance -= amount;
                System.out.println("New balance after withdrawal: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + ": Insufficient funds");
            }
        }
    }

    public double getBalance() {
        return balance;
    }
}

class BankTransaction implements Runnable {
    private final BankAccount account;
    private final boolean isDeposit;
    private final double amount;

    public BankTransaction(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

public class BankingDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new Thread(new BankTransaction(account, true, 500), "DepositThread");
        Thread t2 = new Thread(new BankTransaction(account, false, 700), "WithdrawThread1");
        Thread t3 = new Thread(new BankTransaction(account, false, 900), "WithdrawThread2");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}