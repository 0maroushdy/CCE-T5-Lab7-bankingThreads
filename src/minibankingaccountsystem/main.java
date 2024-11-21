/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minibankingaccountsystem;

/**
 *
 * @author Omar
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         BankAccount account = new BankAccount("12345", 500.0);

        DepositThread depositThread = new DepositThread(account);
        WithdrawThread withdrawThread = new WithdrawThread(account);


        try {
            depositThread.start();
            withdrawThread.start();
            for(int i =0; i<10; i++){
                depositThread.run();
                withdrawThread.run();
            }    
//                depositThread.join();
//                withdrawThread.join();
        } catch (Exception e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        // Print final account balance
        System.out.println("\nCurrent Account Balance: " + account.getBalance());
        account.printTransactionLog();
    }
            
}
