/*
 * Problem 14 Solution
 *
 * @author Dyland Xue
 * @version 12/31/13
 *
 * Which starting number, under one million, produces the longest chain?
 */

import java.math.BigInteger;

public class Problem14
{
    public static int lengthOfChain(int n)
    {
        int length = 0;
        BigInteger temp = BigInteger.valueOf(n);
        BigInteger two = BigInteger.valueOf(2);
        BigInteger three = BigInteger.valueOf(3);
        while (!temp.equals(BigInteger.ONE))
        {
            length++;
            if (temp.mod(two).equals(BigInteger.ZERO))
                temp = temp.divide(two);
            else
                temp = temp.multiply(three).add(BigInteger.ONE);
        }

        length++;
        return length;
    }

    public static int findLargestChainUnder(int N)
    {
        long startTime = System.nanoTime();
        int currMax = Integer.MIN_VALUE;
        int maxNumber = 0;
        int curr = 0;
        for (int i = N / 2; i < N; i++)
        {
            if ((i - 1) % 3 == 0)
                continue;

            curr = Problem14.lengthOfChain(i);
            if (curr > currMax)
            {
                maxNumber = i;
                currMax = curr;
            }
        }

        double estimatedTime = System.nanoTime() - startTime;
        estimatedTime /= 1e9;
        System.out.println("Running time for " + N + " is " 
                + estimatedTime);
        System.out.println("number is " + maxNumber 
                + ", length of chain is " + currMax);
        return maxNumber;
    }

    public static void main(String[] args)
    {
        int n = 1000000;
        System.out.println(Problem14.findLargestChainUnder(n));
        //System.out.println(Problem14.lengthOfChain(504057));
    }
}
