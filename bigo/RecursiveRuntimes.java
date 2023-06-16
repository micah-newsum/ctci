package bigo;

public class RecursiveRuntimes {
   public static void main(String[] args) {
    System.out.println(f(4));
   }

   /**
    *                                           f(4)
    *                               /                      \
    *                              f(3)                    f(3)
    *                          /         \             /         \
    *                        f(2)        f(2)         f(2)        f(2)
    *                      /     \      /    \        /  \        /   \   
    *                     f(1)   f(1) f(1)   f(1)   f(1) f(1)   f(1)  f(1)
    * Time complexity O(2^N - 1) = O(2^N)
    * 
    * f(4)
    *   f(3)
    *       f(2)
    *           f(1)
    *   f(3)
    *       f(2)
    *           f(1)
    * Space complexity O(N)
    * The algorithm starts by recursively calling the function in the return statement. Once
    * the recursive call returns, the next set of recursive calls begin. 
    * Therefore, the space complexity is O(2N), but we drop the constants so it's just O(N)
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
