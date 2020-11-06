
/**
 * A class for Expression Evaluation ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 */
public class Evaluate {
    public static void main(String[] args) {
        String express = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )";
        String[] s = express.split(" ");
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            String v = s[i];
            if (v.equals("(")) ; // ignore the "("
            else if (v.equals("+")) ops.push(v);
            else if (v.equals("-")) ops.push(v);
            else if (v.equals("*")) ops.push(v);
            else if (v.equals("/")) ops.push(v);
            else if (v.equals("sqrt")) ops.push(v);
            else if (v.equals(")")) {
                // if the op is ')', then compute the result of recently number, and add it to stack
                Double num = vals.pop();
                String op = ops.pop();
                if (op.equals("+")) num = vals.pop() + num;
                else if (op.equals("-")) num = vals.pop() - num;
                else if (op.equals("*")) num = vals.pop() * num;
                else if (op.equals("/")) num = vals.pop() / num;
                else if (op.equals("sqrt")) num = Math.sqrt(num);
                vals.push(num);
            }
            else { // add numbers to the stack
                vals.push(Double.parseDouble(v));
            }
        }
        System.out.println(vals.pop());
    }
}
