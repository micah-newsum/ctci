package bigo;

public class StackSpace {
    public static void main(String[] args) {
        System.out.println(sum(4));
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


}