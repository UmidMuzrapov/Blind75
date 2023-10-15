/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> marked = new HashSet<ListNode>();

        while (head!=null){
            if (marked.contains(head)){
                return true;
            } else{
                marked.add(head);
                head=head.next;
            }
        }

        return false;
    }
}
