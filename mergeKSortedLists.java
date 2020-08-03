// Time Complexity : O(nlogn) where n is the total number of nodes; insert takes O(logn) for each node
// Space Complexity : O(n) where n is the total number of nodes to be stored in a priority queue
// Did this code successfully run on Leetcode : yes
//approach: 1. we make a min heap and add all the nodes of all linked lists to it so that when we start popping, we get nodes in ascending order
//2. add these popped nodes to the new result list.



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
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
        for(ListNode head : lists)
        {
            while(head!=null)
            {
                minheap.add(head.val);
                head=head.next;
            }
        }
        ListNode dummyhead = new ListNode(-1);
        ListNode head = dummyhead;
        while(!minheap.isEmpty())
        {
            head.next = new ListNode(minheap.poll());
            head = head.next;
        }
        return dummyhead.next;
    }
}
