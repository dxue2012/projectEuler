/*
 * Problem 2 Solution
 *
 * @author Dyland Xue
 * @version 12/24/13
 *
 */

public class Problem2
{
    public static int fastSumOfEvenFibNumbers(int N)
    {
        long startTime = System.nanoTime();
        int sum = 0;
        int i = 0;
        int j = 2;
        int prevJ = 2;
        while (i < N)
        {
            sum += i;
            j = 4 * j + i;
            i = prevJ;
            prevJ = j;
        }

        double estimatedTime = System.nanoTime() - startTime;
        estimatedTime /= 1e9;
        System.out.println("Running time for " + N + " is " 
                + estimatedTime);

        return sum;
    }

    public static int sumOfEvenFibNumbers(int N)
    {
        long startTime = System.nanoTime();
        int sum = 0;
        int i = 1;
        int j = 1;
        while (i < N && j < N)
        {
            sum += i;
            sum += j;

            i = i + j;
            j = i + j;
        }

        /* if both i and j are odd, then the sum of even is 1/2 of the
         * total sum
         */
        if (i % 2 == 1 && j % 2 == 1)
            sum /= 2;
        else if (i % 2 == 0 && j % 2 == 1)
            sum = (sum + i) / 2;
        else if (i % 2 == 1 && j % 2 == 0)
            sum = (sum + i + j) / 2;

        double estimatedTime = System.nanoTime() - startTime;
        estimatedTime /= 1e9;
        System.out.println("Running time for " + N + " is " 
                + estimatedTime);

        return sum;
    }

    public static void main(String[] args)
    {
        int N;
        if (args.length == 1)
            N = Integer.parseInt(args[0]);
        else
            N = 4000000;

        System.out.println("N = " + N);
        System.out.println("sum = " + sumOfEvenFibNumbers(N));
        System.out.println("sum = " + fastSumOfEvenFibNumbers(N));
    }
}
