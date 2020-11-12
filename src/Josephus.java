/*
Josephus problem. In the Josephus problem from antiquity,
N people are in dire straits and agree to the following strategy to reduce the population.
They arrange themselves in a circle (at positions numbered from 0 to N–1) and proceed around the circle,
eliminating every Mth person until only one person is left.
Legend has it that Josephus ﬁgured out where to sit to avoid being eliminated.

Josephus takes N and M from the command line and prints out the order in which people are eliminated
    (and thus would show Josephus where to sit in the circle).
 */

public class Josephus {
    public static void main(String[] args) {
        var m = 2;
        var n = 7;
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < n; i++ ) queue.push(i);

        while (!queue.isEmpty()) {
            for (int i = 0; i < m - 1; i++)
                queue.push(queue.pop());
            System.out.print(queue.pop() + " ");
        }
    }
}
