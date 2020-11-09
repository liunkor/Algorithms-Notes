/**
 * Evaluate the result of postfix
 * input: 2 3 4 + 5 6 * * +
 * output: 212
 */

public class EvaluatePostfix {
    public static void evaluate(String s) {
        String[] ss = s.split(" ");
        Stack<Integer> rs = new Stack<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("+")) {
                int num = rs.pop() + rs.pop();
                rs.push(num);
            }
            else if (ss[i].equals("-")) {
                int later = rs.pop();
                int first = rs.pop();
                int num = first - later;
                rs.push(num);
            }
            else if (ss[i].equals("*")) {
                int num = rs.pop() * rs.pop();
                rs.push(num);
            }
            else if (ss[i].equals("/")) {
                int later = rs.pop();
                int first = rs.pop();
                int num = first / later;
                rs.push(num);
            }
            else {
                rs.push(Integer.parseInt(ss[i]));
            }
        }
        System.out.println(rs.peek());
    }

    public static void main(String[] args) {
        String s = "3 4 + 5 6 * * 2 /";
        evaluate(s);
    }
}
