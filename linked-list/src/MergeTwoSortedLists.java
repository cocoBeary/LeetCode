// 21. Merge Two Sorted Lists
// Easy
// Linked List

// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists.

// Example:

// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

public class MergeTwoSortedLists {
	
	// iterative
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode temp = res;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				temp.next = l2;
				l2 = l2.next;
			} else {
				temp.next = l1;
				l1 = l1.next;
			}
			temp = temp.next;
		}
		if (l1 != null)
			temp.next = l1;
		if (l2 != null)
			temp.next = l2;
		return res.next;
	}

	// recursive
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val > l2.val) {
			l2.next = mergeTwoLists2(l1, l2.next);
			return l2;
		} else {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		MergeTwoSortedLists test = new MergeTwoSortedLists();
		ListNode res = test.mergeTwoLists1(l1, l2);
		while (res != null) {
			System.out.print(res.val);
			res = res.next;
		}
	}
}
