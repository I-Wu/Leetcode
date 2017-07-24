/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public boolean addone(ListNode node){
        if(node.next == null || addone(node.next)){
        	if(node.val == 9){
        		node.val = 0;
        		return true;
        	}
        	else{
        		node.val++;
        		return false;
        	}
        }
        else{
            return false;
        }
    }
    public ListNode plusOne(ListNode head) {
        if(addone(head)){
        	ListNode dummy = new ListNode(1);
        	dummy.next = head;
        	return dummy;
        }
        else
        	return head;

    }
}