package coreFeatures;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable{
    private String name;
    
    private String[] categories;
    
    private BigDecimal[] spendingByCategory;
    
    private Account[] accounts;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
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

    public void removeAccount(int accountIndex) {
        Account[] newAccounts = new Account[getAccounts().length - 1];
        for (int i = 0; i < getAccounts().length; i++) {
            if (i != accountIndex) {
                newAccounts[i] = getAccounts()[i];
            }
        }
        setAccounts(newAccounts);
    }

    public void removeAccount(Account account) {
        Account[] newAccounts = new Account[getAccounts().length - 1];
        for (int i = 0; i < getAccounts().length; i++) {
            if (!account.equals(getAccounts()[i])) {
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
    }

    public void removeCategory(int categoryIndex) {
        String[] newCategories = new String[getCategories().length - 1];
        BigDecimal[] newSpending = new BigDecimal[getCategories().length - 1];

        for (int i = 0; i < getCategories().length; i++) {
            if (i != categoryIndex) {
                newCategories[i] = getCategories()[i];
                newSpending[i] = getSpendingByCategory()[i];
            }
        }

        setCategories(newCategories);
        setSpendingByCategory(newSpending);
    }

    public void removeCategory(String category) {
        String[] newCategories = new String[getCategories().length - 1];
        BigDecimal[] newSpending = new BigDecimal[getCategories().length - 1];

        for (int i = 0; i < getCategories().length; i++) {
            if (!getCategories()[i].equals(category)) {
                newCategories[i] = getCategories()[i];
                newSpending[i] = getSpendingByCategory()[i];
            }
        }

        setCategories(newCategories);
        setSpendingByCategory(newSpending);
    }

    public void addCategories(String category) {
        String[] newCategories = new String[getCategories().length + 1];
        BigDecimal[] newSpending = new BigDecimal[getCategories().length + 1];

        for (int i = 0; i < getCategories().length; i++) {
            newCategories[i] = getCategories()[i];
            newSpending[i] = getSpendingByCategory()[i];
        }

        newCategories[newCategories.length - 1] = category;
        setCategories(newCategories);

        newSpending[newCategories.length - 1] = BigDecimal.ZERO;
        setSpendingByCategory(newSpending);
    }

    public BigDecimal[] getSpendingByCategory() {
        return spendingByCategory;
    }

    public void setSpendingByCategory(BigDecimal[] spendingByCategory) {
        this.spendingByCategory = spendingByCategory;
    }
}
