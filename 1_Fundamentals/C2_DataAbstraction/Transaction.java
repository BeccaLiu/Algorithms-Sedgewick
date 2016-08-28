package C2_DataAbstraction;

import edu.princeton.cs.algs4.Date;

/**
 * Created by rliu on 8/27/16.
 */
public class Transaction {
    private String who;
    private Date when;
    private double amount;

    public Transaction(String who, Date date, Double amount) {
        if (Double.isInfinite(amount) || Double.isNaN(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        this.who = who;
        this.when = date;
        this.amount = amount;
    }

    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other == null)
            return false;
        if (other.getClass() != this.getClass())
            return false;
        Transaction that = (Transaction) other;
        return (this.amount == that.amount) && (this.who.equals(that.who)) && (this.when.equals(that.when));
    }

    public String toString() {
        return String.format("%-10s %10s %8.2f", who, when, amount);
    }

}
