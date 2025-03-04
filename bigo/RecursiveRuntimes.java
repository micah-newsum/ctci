public class RecursiveRuntimes {
   public static void main(String[] args) {
    System.out.println(f(4));
   }

    /**
     * 
     * Time complexity: O(2^N - 1) = O(2^N)
     *                                           f(4)
     *                               /                      \
     *                              f(3)                    f(3)
     *                          /         \             /         \
     *                        f(2)        f(2)         f(2)        f(2)
     *                      /     \      /    \        /  \        /   \   
     *                     f(1)   f(1) f(1)   f(1)   f(1) f(1)   f(1)  f(1)
     * 
     * Space complexity: O(N) 
     *                                f(4)
     *               f(3)                               f(3)
     *       f(2)            f(2)               f(2)            f(2)
     *   f(1)    f(1)    f(1)    f(1)       f(1)    f(1)    f(1)    f(1)
     * 
     * The space complexity is O(N) because there will be at most N functions on the call stack.
     * The easiest way to recognize this is to visualize all function calls as a binary tree, with the 
     * left half of the tree running to completion and then the right.
     * @param n
     * @return
     */
    static int f(int n) {
        if (n <= 1) {
            return 1;
        }
        return f(n - 1) + f(n - 1);
    }
}
