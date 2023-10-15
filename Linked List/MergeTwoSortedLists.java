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
    /**

        go over both lists{
            if list 1 element < list 2 element:
                put list 1 element
            else put list 2 element
            
        }
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode curOne = list1;
            ListNode curTwo = list2;
            ListNode head = null;
            ListNode tail = null;
            ListNode newNode;

            while (curOne!=null && curTwo!=null){

                if (curOne.val<curTwo.val){
                    newNode = new ListNode(curOne.val); 
                    curOne= curOne.next;
                } else{
                    newNode = new ListNode(curTwo.val); 
                    curTwo = curTwo.next;
                }

                if (head==null){
                    head = newNode;
                    tail = head;
                } else{
                    tail.next = newNode;
                    tail = tail.next;
                }

            }

            while (curOne!=null){
                newNode = new ListNode(curOne.val); 
                curOne = curOne.next;

                if (head==null){
                    head= newNode;
                    tail = head;
                }   else{
                    tail.next = newNode;
                    tail = tail.next;
                }             
                
            }

            while (curTwo!=null){
                newNode = new ListNode(curTwo.val); 
                curTwo = curTwo.next;

                if (head==null){
                    head= newNode;
                    tail = head;
                } else{
                    tail.next = newNode;
                    tail = tail.next;
                }
               
            }

            return head;
    }
}
