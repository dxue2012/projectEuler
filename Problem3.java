/*
 * Problem 3 Solution
 *
 * @author Dyland Xue
 * @version 12/30/13
 *
 */

import java.math.*;

public class Problem3
{
    public static BigInteger getLargestPrimeFactor(
            String N, String maxFactorString)
    {
        BigInteger n = new BigInteger(N);
        BigInteger two = new BigInteger("2");
        BigInteger temp = new BigInteger("3");
        BigInteger maxFactor = new BigInteger(maxFactorString);

        while (temp.compareTo(n) < 0) 
        {
            if (n.mod(temp).equals(BigInteger.ZERO))
            {
                System.out.print("n is " + n + " ");
                System.out.println("temp is " + temp);
                n = n.divide(temp);
                if (temp.compareTo(n) >= 0)
                    return temp;
            }

            temp = temp.add(two);
        }

        return n;
    }

    public static void main(String[] args)
    {
        String N = "600851475143";
        String maxFactor = "10000000";
        System.out.println(Problem3.getLargestPrimeFactor(
                    N, maxFactor));
    }
}
