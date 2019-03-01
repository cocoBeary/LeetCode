/**
 * 7. Reverse Integer
 * 
 * Easy
 * 
 * Math
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123 Output: 321 Example 2:
 * 
 * Input: -123 Output: -321 Example 3:
 * 
 * Input: 120 Output: 21 Note: Assume we are dealing with an environment which
 * could only store integers within the 32-bit signed integer range: [−231,
 * 231 − 1]. For the purpose of this problem, assume that your function
 * returns 0 when the reversed integer overflows.
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		int y = 0;
		while (x != 0) {
			int temp = y * 10 + x % 10;
			if (temp / 10 != y)
				return 0;
			else
				y = temp;
			x = x / 10;
		}
		return y;
	}

	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(0));
		System.out.println(new ReverseInteger().reverse(-123));
		System.out.println(new ReverseInteger().reverse(2350));
		System.out.println(new ReverseInteger().reverse(2147483647));
	}
}
