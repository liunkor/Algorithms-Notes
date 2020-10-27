import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class HelloAlgorithms {
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "  " + fib(i));
        }
    }

    public static long fib(int N) {
        if ((N == 0) || (N == 1)) {
            return N;
        }
        else {
            return fib(N-1) + fib(N-2);
        }
    }
}
