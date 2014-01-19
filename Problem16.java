/*
 * Problem 16 Solution
 *
 * @author Dyland Xue
 * @version 01/19/14
 */

import java.math.BigInteger;

public class Problem16
{
    public static int getSumOfDigits(int base, int power)
    {
        int result = 0;
        BigInteger ratio = BigInteger.valueOf(base);
        BigInteger myNum = ratio.pow(power);
        String numString = myNum.toString();

        for (int i = 0; i < numString.length(); i++)
            result += numString.charAt(i) - '0';

        return result;
    }

    public static void main(String[] args)
    {
        int base = 2;
        int power = 1000;
        System.out.println("This is problem No. 16");
        System.out.println("base: " + base + ", power: " + power);
        int sumOfDigits = Problem16.getSumOfDigits(base, power);
        System.out.println("sum of digits: " + sumOfDigits);
    }
}
