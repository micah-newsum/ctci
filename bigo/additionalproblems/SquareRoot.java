package additionalproblems;

public class SquareRoot {
    public static void main(String[] args) {
        sqrt(100);
    }

    public static int sqrt(int n) {
        return sqrt_helper(n, 1, n);
    }

    public static int sqrt_helper(int n, int min, int max) {
        if (max < min) return -1; // no square root

        int guess = (min + max) /2;
        if (guess * guess == n) { // found it!
            System.out.printf("Found it! %d\n", guess);
            return guess;
        } else if (guess * guess < n) { // too low
            System.out.printf("sqrt_helper(%d, %d, %d)\n", n, guess + 1, max);
            return sqrt_helper(n, guess + 1, max); // try higher
        } else { // too high
            System.out.printf("sqrt_helper(%d, %d, %d)\n", n, min, guess - 1);
            return sqrt_helper(n, min, guess - 1); // try lower
        }
    }
}
