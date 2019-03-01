// 20. Valid Parentheses
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.

// Example 1:

// Input: "()"
// Output: true

// Example 2:

// Input: "()[]{}"
// Output: true

// Example 3:

// Input: "(]"
// Output: false

// Example 4:

// Input: "([)]"
// Output: false

// Example 5:

// Input: "{[]}"
// Output: true
import java.util.*;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;

		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');

		Deque<Character> set = new ArrayDeque<>();

		for (char i : s.toCharArray()) {
			if (!map.containsKey(i))
				set.push(i);
			else {
				if (set.isEmpty() || set.pop() != map.get(i))
					return false;
			}
		}

		return set.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid("()[]{}"));
		System.out.println(test.isValid("([)]"));
		System.out.println(test.isValid("{[]}"));
	}
}
