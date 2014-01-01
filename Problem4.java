/*
 * Problem 4 Solution
 *
 * @author Dyland Xue
 * @version 12/30/13
 *
 * Find the largest palindrome made from the product of 
 * two 3-digit numbers.
 */

public class Problem4
{
    public static boolean isPalindrome(int N)
    {
        String n = new Integer(N).toString();
        int length = n.length();
        for (int i = 0; i < length / 2; i++)
        {
            if (n.charAt(i) != n.charAt(length - i - 1))
                return false;
        }

        return true;
    }

    /**
     * @param n the number of digits of each factor
     * @return the largest paindrome made from the product of two
     * n-digit numbers
     */
    public static int getLargestPalindrome(int n)
    {
        int largestNumber = (int)Math.pow(10, n) - 1;
        int smallestNumber = (int)Math.pow(10, n-1);
        int currMax = Integer.MIN_VALUE;
        int curr = 0;
        for (int i = largestNumber; i >= smallestNumber; i--)
        {
            for (int j = largestNumber; j >= smallestNumber; j--)
            {
                curr = i * j;
                if (curr < currMax)
                    break;
                if (Problem4.isPalindrome(curr) && curr > currMax)
                    currMax = curr;
            }
        }

        if (currMax == Integer.MIN_VALUE)
            return -1;
        else
            return currMax;
    }

    public static void main(String[] args)
    {
        int digits = 10;
        System.out.println(getLargestPalindrome(digits));
    }
}
