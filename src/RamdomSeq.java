import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RamdomSeq {
    private RamdomSeq() {}

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        if (args.length == 1) {
            // generate and print n numbers between 0.0 and 1.0
            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniform();
                StdOut.println(x);
            }
        }
        else if (args.length == 3) {
            double lo = Double.parseDouble(args[1]);
            double hi = Double.parseDouble(args[2]);
            // generate and print n numbers between lo and hi
            for (int i = 0; i < n; i++) {
                double x = StdRandom.uniform(lo, hi);
                StdOut.printf("%.2f\n", x);
            }
        }
        else {
            throw new IllegalArgumentException("Invalid number of arguments");
        }
    }
}
