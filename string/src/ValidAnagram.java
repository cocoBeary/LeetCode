/***
 * 242. Valid Anagram
 * 
 * Easy
 * 
 * Given two strings s and t , write a function to determine if t is an anagram
 * of s.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram"
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: s = "rat", t = "car"
 * 
 * Output: false
 * 
 * Note:
 * 
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * 
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 *
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()) return false;
		int[] res=new int[256];
		for(int i= 0;i<s.length();i++) {
			res[s.charAt(i)]++;
			res[t.charAt(i)]--;
		}
		for(int i= 0;i<res.length;i++) {
			if(res[i]!=0) return false;
		}
		return true;

	}
	
	public static void main(String[] args) {
		System.out.println(new ValidAnagram().isAnagram("anagram","nagaram"));
	}

}
