package coreFeatures;

import java.math.BigDecimal;
import java.time.LocalDate;

/*
 * Should hold data on if it is repeating/non-repeating transaction. When the transaction takes place
 *     and how often it repeats (if applicable). Should also hold a money value (negative for purchase,
 *     positive for paychecks).
 * 
 * The Account class will hold an array or list of many many Transactions, so try to keep it lightweight on
 *     resources during initialization if possible, so as to make importing big files quicker.
 */
public class Transaction {
    private BigDecimal amount;
    private LocalDate date;
    private String description;

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    Transaction(BigDecimal amount, LocalDate date, String description){
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
    
}
