/**
 * 58. Length of Last Word
 * 
 * Easy
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * Example:
 * 
 * Input: "Hello World"
 * 
 * Output: 5
 *
 */
public class LengthofLastWord {
	// time O(1) space O(1)
	public int lengthOfLastWord(String s) {
		return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
	}

	public int lengthOfLastWord1(String s) {
		boolean flag = false;
		int length = 0;
		for (int i = s.length() - 1; i > -1; i--) {
			if (s.charAt(i) != ' ') {
				length += 1;
				flag = true;
			} else if (s.charAt(i) == ' ' && flag) {
				break;
			}
		}
		return length;
	}

	public static void main(String[] args) {
		LengthofLastWord test = new LengthofLastWord();
		System.out.println(test.lengthOfLastWord("Hello World"));
		System.out.println("hello".lastIndexOf(" "));
	}
}
