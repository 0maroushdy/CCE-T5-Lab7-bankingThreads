package minibankingaccountsystem;

import java.util.Random;

/**
 *
 * @author Omar
 */
public class WithdrawThread extends Thread {
    private BankAccount account;
    private Random random;
    private int MAX;
    private int MIN;

    //the cnstractor -----------------------------
    public WithdrawThread(BankAccount account) {
        this.account = account;
        this.random = new Random();
        MAX = 100;
        MIN = 10;
    }
    
    public WithdrawThread(BankAccount account, int MAX, int MIN) {
        this.account = account;
        this.random = new Random();
        this.MAX = MAX;
        this.MIN = MIN;
    }

    @Override
    public void run() {
            int amount = random.nextInt(MAX - MIN +1) + MIN; // Gen random amount between 10 and 100
            try {
                account.Withdraw(amount);
            } catch (InvalidTransactionException e) {
                System.err.println(e.getMessage());
            }
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.err.println("WithdrawThread interrupted: " + e.getMessage());
            }
    }
    
}
