/**
 * Fix an expression without left parentheses,
 * then prints the equivalent inﬁx expression with the parentheses inserted.
 * input: 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) then output: ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class FixParentheses {

    public static void fixParentheses(String s) {
        String[] ss = s.split(" ");
        Stack<String> op = new Stack<>();
        Stack<String> ep = new Stack<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("+")
                    || ss[i].equals("-")
                    || ss[i].equals("*")
                    || ss[i].equals("/"))
                op.push(ss[i]);
            else if (ss[i].equals(")")) {
                String later = ep.pop();
                String first = ep.pop();
                String tmp = "( " + first + " " + op.pop() + " " + later + " )";
                ep.push(tmp);
            }
            else
                ep.push(ss[i]);
        }
        if (!ep.isEmpty())
            System.out.println(ep.peek());
    }

    public static void main(String[] args) {
        String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        fixParentheses(s);
    }
}
