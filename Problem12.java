/*
 * Problem 12 Solution
 *
 * @author Dyland Xue
 * @version 12/31/13
 *
 * What is the value of the first triangle number 
 * to have over five hundred divisors?
 */

import java.math.BigInteger;

public class Problem12
{
    public static BigInteger sqrt(BigInteger n) 
    {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while(b.compareTo(a) >= 0) 
        {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
            else a = mid.add(BigInteger.ONE);
        }
        return a.subtract(BigInteger.ONE);
    }

    public static BigInteger getNthTriangleNumber(BigInteger n)
    {
        BigInteger two = new BigInteger("2");
        return (n.add(BigInteger.ONE)).multiply(n).divide(two);
    }

    public static BigInteger getFirstTriangleNumberWithNDivisors(int N)
    {
        BigInteger i = BigInteger.valueOf(N);
        BigInteger triangleNum = Problem12.getNthTriangleNumber(i);
        while (Problem12.numberOfDivisors(triangleNum) < N)
        {
            i = i.add(BigInteger.ONE);
            triangleNum = Problem12.getNthTriangleNumber(i);
        }

        return triangleNum;
    }

    /* return the number of divisors of N */
    public static int numberOfDivisors(BigInteger N)
    {
        int num = 0;
        BigInteger i;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger sqrtOfN = Problem12.sqrt(N);
        if (N.mod(two).equals(BigInteger.ONE))
        {
            for (i = new BigInteger("1"); 
                    i.compareTo(sqrtOfN) <= 0; i = i.add(two))
            {
                if (N.mod(i).equals(BigInteger.ZERO))
                    num++;
            }
        }
        else
        {
            for (i = new BigInteger("1"); 
                    i.compareTo(sqrtOfN) <= 0; i = i.add(BigInteger.ONE))
            {
                if (N.mod(i).equals(BigInteger.ZERO))
                    num++;
            }
        }

        return num * 2;
    }

    public static void main(String[] args)
    {
        int N = 500;
        System.out.println(getFirstTriangleNumberWithNDivisors(N));
    }
}
