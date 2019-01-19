// 206. Reverse Linked List
// Easy
// Linked List

// Reverse a singly linked list.

// Example:

// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
// Follow up:

// A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class ReverseLinkedList {

	// recursive
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode res = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return res;
	}

	// iterative
	public ListNode reverseList2(ListNode head) {
		ListNode res = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = res;
			res = head;
			head = temp;
		}
		return res;
	}

	// iterative
	public ListNode reverseList3(ListNode head) {
		ListNode current = head;
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
		ReverseLinkedList test = new ReverseLinkedList();
		ListNode res = test.reverseList3(l1);
		while (res != null) {
			System.out.print(res.val);
			res = res.next;
		}
	}
}
