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

    public ListNode merge(ListNode[] lists, int i, int n){
        if(i+1 == n) return lists[i];

        ListNode list1 = lists[i];
        ListNode list2 = lists[i+1];

        list2 = merge(lists, i+1, n);

        if(list1 == null && list2 == null) return null;
        else if(list1 == null) return list2;
        else if(list2 == null) return list1;
        else{

            ListNode head = null;

            if(list1.val <= list2.val){
                head = list1;
                list1 = list1.next;
            }
            else{
                head = list2;
                list2 = list2.next;
            }

            ListNode curr = head;

            while(list1 != null && list2 != null){
                if(list1.val <= list2.val){
                    curr.next = list1;
                    list1 = list1.next;
                }
                else{
                    curr.next = list2;
                    list2 = list2.next;
                }
                curr = curr.next;
            }

            if(list1 != null) curr.next = list1;
            else curr.next = list2;

            return head;
        } 
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        return merge(lists, 0, lists.length);
    }
}
