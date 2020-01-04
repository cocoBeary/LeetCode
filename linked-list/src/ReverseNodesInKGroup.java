/**
 * 25. Reverse Nodes in k-Group
 * Hard
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);

            head = reverseLinkedList(head, k, curr);
//            ListNode cur = head;
//            ListNode next = null;
//            ListNode pre = curr;
//            while (count-- > 0) {
//                next = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = next;
//            }
//            head = pre;
        }
        return head;
    }

    public ListNode reverseLinkedList(ListNode start, int k, ListNode end) {
        ListNode pre = end, cur = start, next = null;
        while (k-- > 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;

        ReverseNodesInKGroup group = new ReverseNodesInKGroup();
        ListNode node = group.reverseKGroup(a, 3);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
