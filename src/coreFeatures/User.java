package coreFeatures;

import java.math.BigDecimal;

public class User {
    private String[] categories = new String[] {"Food", "Snacks and self regret purchases", "Gas", "Entertainment", "Housing", "Subscriptions"};

    private BigDecimal[] spendingByCategory = new BigDecimal[categories.length];
    
    private Account[] accounts;

    //set the category size and then make a checkings and savings account
    public User(int categorySize){
        categorySetSize(categorySize);

        accounts = new Account[2];
        accounts[0] = new Account("Checking", BigDecimal.ZERO, false);
        accounts[1] = new Account("Savings", BigDecimal.ZERO, true);
    }

    public BigDecimal findNetWorth(){
        BigDecimal total = BigDecimal.ZERO;
        for(Account a : accounts){
            total.add(a.getBalance());
        }
        return total;
    }

    public User(){
        //25 default value
        this(25);
    }

    public Account[] getAccounts(){
        return accounts;
    }

    public void setAccounts(Account[] accounts){
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        Account[] newAccounts = new Account[getAccounts().length + 1];
        for(int i = 0; i < getAccounts().length; i++){
            newAccounts[i] = getAccounts()[i];
        }
        newAccounts[newAccounts.length-1] = account;
        setAccounts(newAccounts);
    }

    public String[] getCategories(){
        return categories;
    }
    
    public void setCategories(String[] catagories){
        this.categories = catagories;
        //TODO: Update spendingByCategory to match
    }

    public void addCategories(String category){
        String[] newCategories = new String[getCategories().length + 1];

        for(int i = 0; i < getCategories().length; i++){
            newCategories[i] = getCategories()[i];
        }
        newCategories[newCategories.length-1] = category;
        setCategories(newCategories);
    }
}
