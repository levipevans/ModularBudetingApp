package coreFeatures;
/*
 * Will represent a single account, either checking or savings (or whatever).
 * 
 * Should hold data like account balance, transaction history, and future transactions.
 * 
 * Can partition balance into sections of what you can use, and what is needed to be spent on bills.
 *     It should also be able to hold future paychecks as well.
 */

import java.math.BigDecimal;

public class Account {
    String name;
    private BigDecimal balance;
    private Transaction[] transactionHistory;

    private boolean hasInterestRate;
    private BigDecimal interestRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    public void addToBalance(BigDecimal balance) {
        this.balance.add(balance);
    }

    public Transaction[] getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(Transaction[] transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public boolean isHasInterestRate() {
        return hasInterestRate;
    }

    public void setHasInterestRate(boolean hasInterestRate) {
        this.hasInterestRate = hasInterestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Account(String name, BigDecimal balance, boolean hasInterestRate){
        this.name = name;
        this.balance = balance;
        this.hasInterestRate = hasInterestRate;
    }
}
