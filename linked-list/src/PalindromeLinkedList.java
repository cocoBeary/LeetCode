// 234. Palindrome Linked List
// Easy
// Linked List, Two Pointers

// Given a singly linked list, determine if it is a palindrome.

// Example 1:

// Input: 1->2
// Output: false

// Example 2:

// Input: 1->2->2->1
// Output: true
// Follow up:
// Could you do it in O(n) time and O(1) space?

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = reverse(slow);
		fast = head;
		while (slow != null) {
			if (slow.val != fast.val)
				return false;
			slow = slow.next;
			fast = fast.next;
		}

		return true;

	}

	public ListNode reverse(ListNode node) {
		ListNode current = node;
		ListNode pre = null;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		PalindromeLinkedList test = new PalindromeLinkedList();
		System.out.println(test.isPalindrome(l1));
	}
}
