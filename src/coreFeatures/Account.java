package coreFeatures;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Represents an account with financial details and transaction history.
 * Supports reading transaction data from CSV files.
 * 
 * @author Levi Evans
 * @version 1.0
 */
public class Account {
    String name;
    private BigDecimal balance;
    private Transaction[] transactionHistory;

    private boolean hasInterestRate;
    private BigDecimal interestRate;

    // these headers are the strings that the csv files uses to identify the columns for each data type.
    private String amountCsvHeader;
    private String dateCsvHeader;
    private String descriptionCsvHeader;
    private int dateCsvIndex = -1;
    private int descriptionCsvIndex = -1;
    private int amountCsvIndex = -1;
    private AccountType accountType;
    
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAmountCsvHeader() {
        return amountCsvHeader;
    }

    public void setAmountCsvHeader(String amountHeader) {
        this.amountCsvHeader = amountHeader;
    }

    public String getDateCsvHeader() {
        return dateCsvHeader;
    }

    public void setDateCsvHeader(String dateHeader) {
        this.dateCsvHeader = dateHeader;
    }

    public String getDescriptionCsvHeader() {
        return descriptionCsvHeader;
    }

    public void setDescriptionCsvHeader(String descriptionHeader) {
        this.descriptionCsvHeader = descriptionHeader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        calculateBalance();
        return balance;
    }

    /**
     * Recalculates and updates the balance of the account based on the transaction history.
     */
    public void calculateBalance(){
        BigDecimal newBalance = BigDecimal.ZERO;
        for (Transaction transaction : transactionHistory) {
            newBalance = newBalance.add(transaction.getAmount());
        }
        balance = newBalance;
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

    /**
     * Adds a transaction to the account's transaction history.
     * 
     * @param transaction The transaction to add.
     */
    public void addTransaction(Transaction transaction) {
        Transaction[] tempTransactionHistory = new Transaction[this.transactionHistory.length + 1];

        for (int i = 0; i < this.transactionHistory.length; ++i) {
            tempTransactionHistory[i] = transactionHistory[i];
        }

        tempTransactionHistory[tempTransactionHistory.length - 1] = transaction;
        transactionHistory = tempTransactionHistory;
    }

    /**
     * Removes a specific transaction from the account's transaction history.
     * 
     * @param transaction The transaction to remove.
     */
    public void removeTransaction(Transaction transaction){
        Transaction[] tempTransactionHistory = new Transaction[this.transactionHistory.length - 1];

        for (int i = 0; i < this.transactionHistory.length; ++i) {
            if(!transaction.equals(getTransactionHistory()[i])){
                tempTransactionHistory[i] = transactionHistory[i];
            }
        }

        transactionHistory = tempTransactionHistory;
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
/**
     * Constructs an account with a name and initial balance.
     * 
     * @param name The name of the account.
     * @param balance The initial balance.
     */
    public Account(String name, double balance) {
        this.name = name;
        this.balance = BigDecimal.valueOf(balance);
    }
    
/**
     * Constructs an account with a name, initial balance, and interest rate details.
     * 
     * @param name The name of the account.
     * @param balance The initial balance.
     * @param interestRate The interest rate, if applicable.
     */
    public Account(String name, double balance, double interestRate) {
        this.name = name;
        this.balance = BigDecimal.valueOf(balance);
        this.hasInterestRate = true;
        this.interestRate = BigDecimal.valueOf(interestRate);
    }

    /**
     * Reads transaction data from a CSV file and adds them to the account.
     * 
     * @param pathString The file path of the CSV file.
     */
    public void readCsvFile(String pathString){
        File file = new File(pathString);
        try (Scanner scanner = new Scanner(file)) {
            String csvHeaders = scanner.nextLine();
            String[] headersArray = csvHeaders.split(",");

            setHeaderIndexes(headersArray);

            addTransactionsFromCsv(scanner);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    private void addTransactionsFromCsv(Scanner scanner) {
        while(scanner.hasNextLine()){
            String row = scanner.nextLine();
            String[] rowArray = row.split(",");

            addTransaction(new Transaction(
                BigDecimal.valueOf(Double.parseDouble(rowArray[amountCsvIndex])),
                LocalDate.parse(rowArray[dateCsvIndex]),
                rowArray[descriptionCsvIndex]));
        }
    }

    private void setHeaderIndexes(String[] headersArray) {
        for(int i = 0; i < headersArray.length; i++){
            if(headersArray[i].equals(getAmountCsvHeader())){
                amountCsvIndex = i;
            }
            if(headersArray[i].equals(getDateCsvHeader())){
                dateCsvIndex = i;
            }
            if(headersArray[i].equals(getDescriptionCsvHeader())){
                descriptionCsvIndex = i;
            }
        }
    }
        
}
