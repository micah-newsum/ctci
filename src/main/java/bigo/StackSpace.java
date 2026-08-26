package bigo;

public class StackSpace {
    public static void main(String[] args) {
        System.out.println(sum(4));
        System.out.println(pairSumSequence(4));
    }

    /**
    * This algorithm taks O(n) time and space because every value from incurs a function
    * call and each call adds a level to the stack.
    * 
    * sum(4) returns 10 to caller
    *  -> sum(3) returns 6 to caller
    *      -> sum(2) returns 3 to caller
    *          -> sum(1) returns 1 to caller
    *              -> sum(0) returns 0 to caller
    */
    static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n-1);
    }

    /**
     * There will be roughly O(n) calls to pairSum. However, those calls do not exist simultaneously on the call stack,
     * so you only need O(1) space.
     * 
     * Adds adjacent elements between 0 and n.
     * pairSum(0, 1) returns 1 to caller
     * pairSum(1, 2) returns 3 to caller
     * pairSum(2, 3) returns 5 to caller
     * pairSum(3, 4) returns 7 to callers
     * @param n
     * @return
     */
    static int pairSumSequence(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i + 1);
        }
        return sum;
    }

    static int pairSum(int a, int b) {
        return a + b;
    }
}