package coreFeatures;

import java.math.BigDecimal;

public class User {
    private String[] categories;

    private BigDecimal[] spendingByCategory = new BigDecimal[categories.length];

    private Account[] accounts;

    // set the category size and then make a checkings and savings account

    public User() {
        // default values
        setCategories(new String[] { "Food", "Gas", "Entertainment", "Housing", "Subscriptions" });

    }

    public BigDecimal findNetWorth() {
        BigDecimal total = BigDecimal.ZERO;
        for (Account a : accounts) {
            total.add(a.getBalance());
        }
        return total;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public void removeAccount(int accountIndex){
        Account[] newAccounts = new Account[getAccounts().length - 1];
        for(int i = 0; i < getAccounts().length; i++){
            if(i != accountIndex){
                newAccounts[i] = getAccounts()[i];
            }
        }
        setAccounts(newAccounts);
    }

    public void removeAccount(Account account){
        Account[] newAccounts = new Account[getAccounts().length - 1];
        for(int i = 0; i < getAccounts().length; i++){
            if(!account.equals(getAccounts()[i])){
                newAccounts[i] = getAccounts()[i];
            }
        }
        setAccounts(newAccounts);
    }

    public void addAccount(Account account) {
        Account[] newAccounts = new Account[getAccounts().length + 1];
        for (int i = 0; i < getAccounts().length; i++) {
            newAccounts[i] = getAccounts()[i];
        }
        newAccounts[newAccounts.length - 1] = account;
        setAccounts(newAccounts);
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] catagories) {
        this.categories = catagories;
        // TODO: Update spendingByCategory to match
    }

    public void addCategories(String category) {
        String[] newCategories = new String[getCategories().length + 1];

        for (int i = 0; i < getCategories().length; i++) {
            newCategories[i] = getCategories()[i];
        }
        newCategories[newCategories.length - 1] = category;
        setCategories(newCategories);
    }
}
