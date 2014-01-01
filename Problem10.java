/*
 * Problem 10 Solution
 *
 * @author Dyland Xue
 * @version 12/31/13
 *
 * Find the sum of all the primes below two million.
 */

import java.math.BigInteger;

public class Problem10
{
    private int[] primes;
    private int currIndex;
    private BigInteger sum;

    /* find all primes less than N */
    public Problem10(int N)
    {
        primes = new int[N];
        primes[0] = 2;
        currIndex = 1;
        sum = new BigInteger("2");

        findPrimes(N);
    }

    private void findPrimes(int N)
    {
        int currNumber = 3;
        while (currNumber < N)
        {
            if (isPrime(currNumber))
            {
                primes[currIndex] = currNumber;
                sum = sum.add(BigInteger.valueOf(currNumber));
                currIndex++;
            }

            currNumber += 2;
        }
    }

    public boolean isPrime(int N)
    {
        if (N % 2 == 0 && N != 2)
            return false;
        else if (N == 2)
            return true;

        for (int i = 0; i < currIndex; i++)
        {
            if (N % primes[i] == 0)
                return false;
        }

        return true;
    }

    public int getNthPrime(int N)
    {
        return primes[N - 1];
    }

    public BigInteger getSumOfPrimesBelow(int N)
    {
        /*
        int sum = 0;
        for (int i = 0; primes[i] < N; i++)
            sum += primes[i];
            */

        return sum;
    }

    public static void main(String[] args)
    {
        int N = 2000000;
        Problem10 mySolution = new Problem10(N);
        System.out.println(mySolution.getSumOfPrimesBelow(N));
    }
}
