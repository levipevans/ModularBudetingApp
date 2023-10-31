package coreFeatures;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * Represents a user with various financial data and accounts.
 * Implements the Serializable interface for object serialization.
 * @author Glen "River" Seeber
 * @author Levi Evans
 * 
 * @version 1.0
 */
public class User implements Serializable {
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

    /**
     * 
     * @return the total of all user's account balances
     */
    public BigDecimal findNetWorth() {
        // TODO: test that this properly takes into account if the total is being accounted for.

        BigDecimal total = BigDecimal.ZERO;
        for (Account a : accounts) {
            switch (a.getAccountType()) {
                case debit:
                    total.add(a.getBalance());
                    break;
                case credit:
                    total.subtract(a.getBalance());
                    break;
            
                default:
                    System.out.println(a.getName() + ": did not have an accounted for account type (debit, credit...)");
                    break;
            }
        }
        return total;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    /**
     * 
     * @param accountIndex The index of the account to remove from the user's
     *                     account array.
     */
    public void removeAccount(int accountIndex) {
        Account[] newAccounts = new Account[getAccounts().length - 1];
        for (int i = 0; i < getAccounts().length; i++) {
            if (i != accountIndex) {
                newAccounts[i] = getAccounts()[i];
            }
        }
        setAccounts(newAccounts);
    }

    /**
     * 
     * @param account the account object to be removed from the user's account
     *                array.
     */
    public void removeAccount(Account account) {
        Account[] newAccounts = new Account[getAccounts().length - 1];
        for (int i = 0; i < getAccounts().length; i++) {
            if (!account.equals(getAccounts()[i])) {
                newAccounts[i] = getAccounts()[i];
            }
        }
        setAccounts(newAccounts);
    }

    /**
     * 
     * @param account The account to add to the user's accounts array.
     */
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

    /**
     * Removes a category and its related spendingByCategory entry from their respective arrays.
     * @param categoryIndex the index of the user's category and spendingByCategory
     *                      arrays to be removed.
     */
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

    /**
     * Removes a category and its related spendingByCategory entry from their respective arrays.
     * @param category The category and the spendingByCategory entry with the same
     *                 index to be removed.
     */
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

    /**
     * Adds a category to the categories array and a related location in the user's spendingByCategory array.
     * @param category The category to be added
     */
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
