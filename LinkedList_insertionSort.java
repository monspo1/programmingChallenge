import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static class ListNode{
	    int val;
	    ListNode next;
	    ListNode(int val){
	        this.val = val;
	        next = null;
	    }
	}

	// PrintList
	public static void printList(ListNode head){
	        while(head != null){
	            System.out.print(head.val + " -> ");
	            head = head.next;
	        }
	        System.out.print("NULL\n");
	}
	
    // Solution 1: My solution
	public static ListNode insertionSort(ListNode a) {
		if(a == null) return a;
		
		ListNode shead = null;
		ListNode sorted = null;
        ListNode cur = null;
        
		while(a != null){
			cur = new ListNode(a.val);
			
			if(sorted == null){
				sorted = cur;
				shead = sorted;
                
			} else{
				sorted = shead;
                
				if(cur.val < sorted.val){
					cur.next = sorted;
					sorted = cur;
					shead = cur;
				} else{
					while(sorted.next != null && cur.val > sorted.next.val ) sorted = sorted.next;
					cur.next = (sorted.next == null)? null : sorted.next;
					if(sorted != null) sorted.next = cur;
				}
			}
			a = a.next;
		}
		return shead;
	}
	
    // Solution 2: LeetCode solution
    // http://www.programcreek.com/2012/11/leetcode-solution-sort-a-linked-list-using-insertion-sort-in-java/
    public static ListNode insertionSortList(ListNode head) {
 
		if (head == null || head.next == null)
			return head;
 
		ListNode newHead = new ListNode(head.val);
		ListNode pointer = head.next;
 
		// loop through each element in the list
		while (pointer != null) {
			// insert this element to the new list
 
			ListNode innerPointer = newHead;
			ListNode next = pointer.next;
 
			if (pointer.val <= newHead.val) {
				ListNode oldHead = newHead;
				newHead = pointer;
				newHead.next = oldHead;
			} else {
				while (innerPointer.next != null) {
 
					if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
						ListNode oldNext = innerPointer.next;
						innerPointer.next = pointer;
						pointer.next = oldNext;
					}
 
					innerPointer = innerPointer.next;
				}
 
				if (innerPointer.next == null && pointer.val > innerPointer.val) {
					innerPointer.next = pointer;
					pointer.next = null;
				}
			}
 
			// finally
			pointer = next;
		}
 
		return newHead;
	}
    
    /* Testcases:
    Testcase 1:
    8 3 7 16 4 8 3 8 1
    Output: 1 -> 3 -> 3 -> 4 -> 7 -> 8 -> 8 -> 16 -> NULL
    
    Testcase 2:
    
    //*/
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();         
		
		ListNode head = new ListNode(0);         
		ListNode prev = null;                  
		
		for(int i = 0; i < n; i++){             
			int v = sc.nextInt();             
			ListNode cur = new ListNode(v);             
			if(i == 0) head = cur;             
			if(i > 0) prev.next = cur;             
			prev = cur;          
		}                  
		
		printList(head);
        
		printList(insertionSort(head));
	}
}