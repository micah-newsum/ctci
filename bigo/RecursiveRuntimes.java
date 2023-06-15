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
    * O(2^N - 1) = O(2^N)
    * 
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
