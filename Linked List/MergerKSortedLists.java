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
    public ListNode mergeKLists(ListNode[] lists) {
           ListNode result = new ListNode();
           ListNode cur = result;
           int minIndex = 0;
           int min = Integer.MAX_VALUE;
           boolean goOn = Arrays.stream(lists).filter(e -> e==null).count()!=lists.length;

           while (goOn){

               for (int i=0; i<lists.length; i++){
                   ListNode list = lists[i];
                   if (list!=null){
                       if (list.val<min){
                           minIndex = i;
                           min = list.val;
                       }
                   }
               }

               ListNode minList = lists[minIndex];
               cur.next = new ListNode(minList.val);
               lists[minIndex] = lists[minIndex].next;
               min = Integer.MAX_VALUE;
               goOn = Arrays.stream(lists).filter(e -> e==null).count()!=lists.length;
               cur = cur.next;
           }

           return result.next;
    }
}
