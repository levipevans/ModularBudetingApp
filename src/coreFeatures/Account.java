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

    public Account(String name, BigDecimal balance, boolean hasInterestRate){
        this.name = name;
        this.balance = balance;
        this.hasInterestRate = hasInterestRate;
    }
}
