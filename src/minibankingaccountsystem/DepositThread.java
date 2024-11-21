package minibankingaccountsystem;

import java.util.Random;

/**
 *
 * @author Omar
 */
public class DepositThread extends Thread {
    private BankAccount account;
    private Random random;
    private int MAX;
    private int MIN;

    //the cnstractor -----------------------------
    public DepositThread(BankAccount account) {
        this.account = account;
        this.random = new Random();
        MAX = 100;
        MIN = 10;
    }

    public DepositThread(BankAccount account, int MAX, int MIN) {
        this.account = account;
        this.random = new Random();
        this.MAX = MAX;
        this.MIN = MIN;
    }
    
    @Override
    public void run() {
            int amount = random.nextInt(MAX - MIN +1) + MIN; // generating random amount between 10 and 100
            try {
                account.Deposit(amount);
            } catch (InvalidTransactionException e) {
                System.err.println(e.getMessage());
            }
            try {
                Thread.sleep(1000); // making Sleep for 1 second
            } catch (InterruptedException e) {
                System.err.println("DepositThread interrupted: " + e.getMessage());
            }  
    }
    
}
