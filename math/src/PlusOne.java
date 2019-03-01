import java.lang.reflect.Array;
import java.util.Arrays;

// 66. Plus One

// Given a non-empty array of digits representing a non-negative integer, plus
// one to the integer.

// The digits are stored such that the most significant digit is at the head of
// the list,
// and each element in the array contain a single digit.

// You may assume the integer does not contain any leading zero, except the
// number 0 itself.

// Example 1:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.

// Example 2:

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int n = digits.length;
		int addOne = 1;
		for (int i = n - 1; i >= 0; i--) {
			int temp = (digits[i] + addOne) % 10;
			addOne = (digits[i] + addOne) / 10;
			digits[i] = temp;
		}
		if (addOne == 0)
			return digits;
		else {
			int[] newDigits = new int[n + 1];
			newDigits[0] = addOne;
			System.arraycopy(digits, 0, newDigits, 1, n);
			return newDigits;
		}

//		int n = digits.length;
//		for (int i = n - 1; i >= 0; i--) {
//			if (digits[i] != 9) {
//				digits[i]++;
//				return digits;
//			}
//			digits[i] = 0;
//		}
//		int[] newNumber = new int[n + 1];
//		newNumber[0] = 1;
//		return newNumber;
	}

	public static void main(String[] args) {
		int[] nums = { 9, 9, 9 };
		int[] nums2 = { 1, 2, 3 };
		PlusOne test = new PlusOne();
		System.out.println(Arrays.toString(test.plusOne(nums)));
		System.out.println(Arrays.toString(test.plusOne(nums2)));
	}
}
