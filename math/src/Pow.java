/**
 * 50. Pow(x, n)
 * Medium
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */

public class Pow {
    // time O(logn) space O(n)
    public double myPow(double x, int n) {
        if (n >= 0)
            return pow(x, n);
        else
            return 1 / pow(x, -n);
    }

    public double pow(double x, int n) {
        if (n == 0)
            return 1;

        double y = pow(x, n / 2);
        if (n % 2 == 0)
            return y * y;
        else
            return y * y * x;
    }
}
