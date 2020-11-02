import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

//The {@code Transaction} class is an immutable data type to encapsulate a
//commercial transaction with a customer name, date, and amount.
public class Transaction implements Comparable<Transaction>{
    private final String who;       // customer
    private final Date when;        // date
    private final double amount;    // amount

    public Transaction(String who, Date when, double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or inifinte");
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] a = transaction.split("\\s+"); // use blank string to split the string
        who = a[0];
        when = new Date(a[1]);
        amount = Double.parseDouble(a[2]);
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
    }

    public String getWho() {
        return who;
    }

    public Date getWhen() {
        return when;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%-10s %10s %8.2f", who, when, amount);
    }

    // Compares two transactions by amount.
    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.amount, o.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return (this.amount == that.amount) && (this.who.equals(that.who))
                && (this.when.equals(that.when));
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31*hash + who.hashCode();
        hash = 31*hash + when.hashCode();
        hash = 31*hash + ((Double)amount).hashCode();
        return hash;
    }

    public static class WhoOrder implements Comparator<Transaction> {
        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.who.compareTo(o2.who);
        }
    }

    public static class WhenOrder implements Comparator<Transaction> {
        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.when.compareTo(o2.when);
        }
    }

    public static class HowMuchOrder implements Comparator<Transaction> {
        @Override
        public int compare(Transaction o1, Transaction o2) {
            return Double.compare(o1.amount, o2.amount);
        }
    }

    public static void main(String[] args) {
        Transaction[] a = new Transaction[4];
        a[0] = new Transaction("Turing   6/17/1990  644.08");
        a[1] = new Transaction("Tarjan   3/26/2002 4121.85");
        a[2] = new Transaction("Knuth    6/14/1999  288.34");
        a[3] = new Transaction("Dijkstra 8/22/2007 2678.40");
        System.out.println("Unsorted");
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

        System.out.println("Sort by customer");
        Arrays.sort(a, new Transaction.WhoOrder());
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

        System.out.println("Sort by date");
        Arrays.sort(a, new Transaction.WhenOrder());
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);

        System.out.println("Sort by amount");
        Arrays.sort(a, new Transaction.HowMuchOrder());
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}
