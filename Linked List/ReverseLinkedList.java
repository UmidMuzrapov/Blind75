/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        ListNode currentNode = head;

        while (currentNode!=null){
            ListNode copy = new ListNode(currentNode.val, reverse);
            reverse = copy;
            currentNode = currentNode.next;
        }
        

        return reverse;
    }
}
