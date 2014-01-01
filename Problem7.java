/*
 * Problem 7 Solution
 *
 * @author Dyland Xue
 * @version 12/31/13
 *
 * What is the 10 001st prime number?
 */

public class Problem7
{
    private int[] primes;
    private int currIndex;

    /* What is the Nth prime number? */
    public Problem7(int N)
    {
        primes = new int[N];
        primes[0] = 2;
        currIndex = 1;

        findPrimes(N);
    }

    private void findPrimes(int N)
    {
        int currNumber = 3;
        while (currIndex < N)
        {
            if (isPrime(currNumber))
            {
                primes[currIndex] = currNumber;
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

    public static void main(String[] args)
    {
        int N = 10001;
        Problem7 mySolution = new Problem7(N);
        System.out.println(mySolution.getNthPrime(N));
    }
}
