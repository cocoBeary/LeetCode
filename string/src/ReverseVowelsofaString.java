/***
 * 345. Reverse Vowels of a String
 * 
 * Easy
 * 
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * Input: "hello"
 * 
 * Output: "holle"
 * 
 * Example 2:
 * 
 * Input: "leetcode"
 * 
 * Output: "leotcede"
 * 
 * Note:
 * 
 * The vowels does not include the letter "y".
 *
 */
public class ReverseVowelsofaString {
	public String reverseVowels(String s) {
		String vowel = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			while (left < right && !isVowels(chars[left])) {
				left++;
			}
			while (left < right && !isVowels(chars[right])) {
				right--;
			}
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;
			left++;
			right--;
		}
		return new String(chars);
	}

	public String reverseVowels2(String s) {
		char[] res = s.toCharArray();
		int start = 0, end = res.length - 1;
		while (start < end) {
			if (isVowels(res[start]) && isVowels(res[end])) {
				char tmp = res[start];
				res[start] = res[end];
				res[end] = tmp;
				start++;
				end--;
			} else if (!isVowels(res[start])) {
				start++;
			} else if (!isVowels(res[end])) {
				end--;
			}
		}
		return new String(res);
	}

	public boolean isVowels(char ch) {
		ch = ch >= 'A' && ch <= 'Z' ? ch += 32 : ch;
		return ch == 'a' || ch == 'o' || ch == 'e' || ch == 'i' || ch == 'u';
	}

	public static void main(String[] args) {
		String input = "hello";

		System.out.println(new ReverseVowelsofaString().reverseVowels(input));
	}
}
