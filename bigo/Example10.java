public class Example10 {
    public static void main(String[] args) {
        System.out.println(isPrime(33));
    }

    /**
     * What's a prime number?
     * A whole number greater than 1 that cannot be exactly
     * divided by any whole number other than itself and 1 (e.g. 2 3, 5, 7, 11)
     * 
     * This method checks if a number is prime by checking for divisibility
     * on numbers less than it. It only needs to go up to the square root of n
     * because if n is divisible by a number greater than its square root then 
     * it's divisible by something smaller than it.
     * 
     * For example, while 33 is divisible by 11 (which is greater than the square root
     * of 33), the "counterpart" to 11 is 3 (3 * 11) = 33. 33 will have already
     * been eliminated as a prime number by 3.
     * 
     * Time complexity: O(sqrt(N))
     * 
     * The for loop will start when x = 2 and end when x*x = n. Or, in other words,
     * when x = the square root of n.
     * @param n
     * @return
     */
    static boolean isPrime(int n) {
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }
}
