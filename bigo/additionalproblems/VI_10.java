package additionalproblems;

public class VI_10 {
    public static void main(String[] args) {
       System.out.println("Ths sum of the digits in 1 is: "+sumDigits(1));
       System.out.println("Ths sum of the digits in 12 is: "+sumDigits(12));
       System.out.println("Ths sum of the digits in 123 is: "+sumDigits(123));
       System.out.println("Ths sum of the digits in 1234 is: "+sumDigits(1234));
    }

    private static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
