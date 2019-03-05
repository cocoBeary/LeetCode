/***
 * 
 * 383. Ransom Note
 * 
 * Easy
 * 
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note:
 * 
 * You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false
 * 
 * canConstruct("aa", "ab") -> false
 * 
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == null)
			return true;
		if (magazine == null)
			return false;

		int[] arr = new int[256];
		for (int i = 0; i < magazine.length(); i++)
			arr[magazine.charAt(i)]++;
		for (int i = 0; i < ransomNote.length(); i++)
			if (--arr[ransomNote.charAt(i)] < 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		String ransomNote = "aa";
		String magazine = "aab";
		System.out.println(new RansomNote().canConstruct(ransomNote, magazine));
	}
}
