package additionalproblems;

public class V1_11 {
    static int numChars = 26;

    public static void main(String[] args) {
        printSortedStrings(5);
    }

    private static void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    /**
     * Example: printSortedStrings(1)
     * ->
     * printSortedStrings(1, "");
     * -> for i -> numChars
     * --> printSortedStrings(0, "a")
     * ---> print "a"
     *
     * Example: printSortedStrings(5)
     * -> printSortedStrings(4, "a")
     * --> printSortedStrings(3, "aa")
     * ---> printSortedStrings(2, "aaa")
     * ----> printSortedStrings(1, "aaaa")
     * -----> printSortedStrings(0, "aaaaa")
     * -----> "aaaaa"
     * ----> printSortedStrings(1, "aaaab")
     * -----> printSortedStrings(0, "aaaab")
     * -----> isInOrder("aaaab")
     * -----> print "aaaab"
     * ----> printSortedStrings(1, "aaaac")
     * -----> printSortedStrings(0, "aaaac")
     * -----> isInOrder("aaaac")
     * -----> print "aaaac"
     * .
     * .
     * .
     * -----> print "zzzzz"
     * @param remaining
     * @param prefix
     */
    private static void printSortedStrings(int remaining, String prefix) {
        if (remaining == 0) {
            if (isInOrder(prefix)) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < numChars; i++) {
                char c = ithLetter(i);
                printSortedStrings(remaining - 1, prefix + c); // called 26 times for each character in string. In other words, c^k times.
            }
        }
    }

    /**
     * O(s) time where s is length of string.
     * @param s
     * @return
     */
    private static boolean isInOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
    }

    private static char ithLetter(int i) {
        return (char) ((int) 'a' + i);
    }
}
