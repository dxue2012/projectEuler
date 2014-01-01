/*
 * Problem 1 Solution
 *
 * @author Dyland Xue
 * @version 12/24/13
 *
 * If we list all the natural numbers below 10 that are multiples of
 * 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

public class Problem1
{
    public static int sumDivisibleBy(int N, int m)
    {
        int target = N - 1;
        int p = target / m;

        return m * (p * (p + 1)) / 2;
    }

    public static void main(String[] args)
    {
        int N = 1000;
        /*
        int sum = 0;
        for (int i = 3; i < 1000; i += 3)
        {
            sum += i;
        }

        System.out.println("sum of multiples of 3 is " + sum);

        for (int i = 5; i < 1000; i += 5)
        {
            sum += i;
        }

        System.out.println(
                "sum of multiples of 3 and 5 (including overlaps) is " 
                + sum);

        for (int i = 15; i < 1000; i += 15)
        {
            sum = sum - i;
        }

        System.out.println("sum is " + sum);
        */

        System.out.println(sumDivisibleBy(N, 3) + sumDivisibleBy(N, 5)
                - sumDivisibleBy(N, 15));
    }
}
