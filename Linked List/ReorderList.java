
class Solution {
    public void reorderList(ListNode head) {
        int count = countNumberOfElements(head);

        if (count > 1) {
            ListNode mid = findMid(head);
            ListNode reversed = reverse(mid.next);
            mid.next = null;
            merge(head, reversed);
        }
    }

    private int countNumberOfElements(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;
            l1.next = l2;
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }
}

