package coreFeatures;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents a financial transaction with an amount, date, and description.
 * 
 * @author Levi Evans
 * @version 1.0
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
    /**
     * 
     * @param amount the amount associated with the transaction
     * @param date the date of the transaction
     * @param description the description or memo of the transaction.
     */
    Transaction(BigDecimal amount, LocalDate date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
}
