public class InfixToPostfix {
    /**
     *  Reads in a fully parenthesized infix expression
     *  then prints an equivalent postfix expression.
     *  e.g input: ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) ) then print: 2 3 4 + 5 6 * * +
     */
    public static void infix2Postfix(String s) {
        String[] ss = s.split(" ");
        Stack<String> op = new Stack<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("("));
            else if (ss[i].equals("+") || ss[i].equals("-") || ss[i].equals("*") || ss[i].equals("/"))
                op.push(ss[i]);
            else if (ss[i].equals(")"))
                System.out.print(op.pop() + " ");
            else
                System.out.print(ss[i] + " ");
        }
    }

    public static void main(String[] args) {
        String s1 = "( ( ( 5 + ( 7 * ( 1 + 1 ) ) ) * 3 ) + ( 2 * ( 1 + 1 ) ) )";
        infix2Postfix(s1);
    }
}
