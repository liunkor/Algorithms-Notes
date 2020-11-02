public class CircularString {
    private CircularString(){}

    public static boolean isCircularString(String a, String b) {
        // a = "ACTGACG";
        // b = "TGACGAC";
        // if a
        if (a.equals(b)) { return true;}
        if (a == null || b == null || a.length() != b.length()) { return false;}
        for (int i = 0; i < a.length(); i++) {
            if (b.startsWith(a.substring(i, a.length()))) {
                int index = i;
                if (a.substring(0, index).equals(b.substring(b.length()-index, b.length()))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Concat string a with string a, then to find it contains the string b.
     * @param a one string
     * @param b one string
     * @return
     */
    public static boolean isCircularString2(String a, String b) {
        if (a.equals(b)) { return true;}
        if (a == null || b == null || a.length() != b.length()) { return false;}
        if (a.concat(a).indexOf(b) >= 0) return true;


        return false;
    }

    public static void main(String[] args) {
        String s = "AAACBTGACG";
        String t = "TGACGAAACB";
        var result = isCircularString2(s, t);
        if (result) {
            System.out.printf("%s with %s is circular string.\n", s, t);
        }
        else {
            System.out.printf("%s with %s is not circular string.\n", s, t);
        }
    }
}
