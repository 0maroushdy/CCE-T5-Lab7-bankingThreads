package minibankingaccountsystem;
import java.util.*;
import java.io.*;

/**
 *
 * @author Omar
 */

public class BankAccount {
    private String id;
    private double balance;
    private ArrayList <String> transactionLog;
    
    // the constructor -----------------------------
    public BankAccount(String id, double balance){
        this.id = id;
        this.balance = balance;
        this.transactionLog = new ArrayList<>();
        transactionLog.add("Account created with balance: " + balance);

    }
    
    // adding balence method -----------------------------
    public void Deposit(double amount)throws InvalidTransactionException{
        if (amount <= 0) {
            throw new InvalidTransactionException("Deposit failed: Amount must be greater than 0");
        }
        
        try{
            balance += amount;
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        String logEntry = "Deposited: +" + amount + ", New Balance: " + balance;
        transactionLog.add(logEntry);
        System.out.println(logEntry);
    }
    
    // withdrawing balance method -----------------------------
    public void Withdraw(double amount)throws InvalidTransactionException{
        if (amount <= 0) {
            throw new InvalidTransactionException("Withdraw failed: Amount must be greater than 0");
        } else if (amount < balance){
            throw new InvalidTransactionException("Withdraw failed: مفيش رصيد كفاية يا صديقي");
        }
            
        try{
            balance -= amount;
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        String logEntry = "Withdrawed: -" + amount + ", New Balance: " + balance;
        transactionLog.add(logEntry);
        System.out.println(logEntry);   
    }
    
    
    //get current balance -----------------------------
    public double getBalance() {
        return balance;
    }

    // print transaction log -----------------------------
    public void printTransactionLog() {
        System.out.println("Transaction Log for Account ID: " + id);
        for (String log : transactionLog) {
            System.out.println(log);
        }
    }

    // Getter for account ID -----------------------------
    public String getId() {
        return id;
    }
    
}
