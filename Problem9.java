/*
 * Problem 9 Solution
 *
 * @author Dyland Xue
 * @version 12/31/13
 *
 * There exists exactly one Pythagorean triplet for 
 * which a + b + c = 1000. Find the product abc.
 */

public class Problem9
{
    public static int findSpecialTriplet()
    {
        int temp;
        int i = 0;
        int j = 0;
        int k = 0;
        for (i = 1; i < 333; i++)
        {
            for (j = i; j < 500; j++)
            {
                temp = 2000 * (i + j) - 2 * i * j - 1000 * 1000;
                if (temp == 0)
                {
                    k = 1000 - i - j;
                    System.out.println("i = " + i + ", j = " + j + ", k = " + k);
                    return i * j * k;
                }
            }
        }

        System.out.println("Not found :(");
        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println(Problem9.findSpecialTriplet());
    }
}
