// Time Complexity : O(m+n) where m is the length of 1st linked list and n is the length of the second linked list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// approach: we create a new linked list and we keep on adding smaller node among l1 and l2.

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummyhead = head;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                head.next = l1;
                l1=l1.next;
            }
            else
            {
                head.next = l2;
                l2=l2.next;
            }
            head=head.next;
        }// after this loop,l1 will become mull and the other pointer l2 will be left at the end node & vice versa
        if(l1==null) head.next=l2; //adding the left over node to the final linked list
        else head.next=l1;
        return dummyhead.next;
    }
}
