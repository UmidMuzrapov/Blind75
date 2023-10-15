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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = numberOfElements(head);

        if (count>1){
            int iterations = count - n;
            ListNode previous = null;
            ListNode current = head;

            while (iterations>0){
                previous = current;
                current=current.next;
                iterations--;  
            }

            if (previous!=null){
                previous.next= current.next;
            } else{
                head = head.next;
            }
        

            return head;
        }

        return null;
    }

    public int numberOfElements(ListNode head){
        int count =0;
        while (head!=null){
            head=head.next;
            count++;
        }

        return count;
    }

}
