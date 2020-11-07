public class Parentheses {

    public static boolean isBalanced(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1) return false;
        Stack<Character> ss = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char o = s.charAt(i);
            if (o == '(') ss.push(o);
            else if (o == '[') ss.push(o);
            else if (o == '{') ss.push(o);
            else {
                if (o == ')') {
                    if (ss.isEmpty()) return false;
                    if (ss.pop() != '(') return false;
                } else if (o == ']') {
                    if (ss.isEmpty()) return false;
                    if (ss.pop() != '[') return false;
                } else if (o == '}') {
                    if (ss.isEmpty()) return false;
                    if (ss.pop() != '{') return false;
                }
            }
        }
        return ss.isEmpty();

    }
    public static void main(String[] args) {
        String s = "[()){}{[()()]()}";
        System.out.println("Is the Parentheses valid? - " + Parentheses.isBalanced(s));
    }
}
