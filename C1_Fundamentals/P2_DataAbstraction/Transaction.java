package P2_DataAbstraction;

import P1_ElementarySorts.Shell;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by rliu on 8/27/16.
 */
public class Transaction implements Comparable<Transaction> {
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

    public static void main(String[] args) {
        Transaction t1 = new Transaction("Mary", new Date("1/1/2015"), 1000.0);
        Transaction t2 = new Transaction("Bob", new Date(9, 18, 2015), 10.0);
        Transaction t3 = new Transaction("Sunny", new Date(9, 10, 2011), 200.0);
        Transaction[] transactions = {t1, t2, t3};
        Shell.sort(transactions);
        for (Transaction t : transactions) {
            StdOut.println(t);
        }
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

    @Override
    public int compareTo(Transaction o) {
        if (this.amount > o.amount) return 1;
        if (this.amount < o.amount) return -1;
        else return 0;
    }
}
