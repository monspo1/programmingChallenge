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
	
	public static ListNode reverseList(ListNode a) {
		ListNode newHead = null;
		ListNode cur = null;
		
		while(a != null){
			
			if(newHead == null){
				newHead = new ListNode(a.val);;
			} else{
				cur = new ListNode(a.val);
				cur.next = newHead;
				newHead = cur;
			}
			a = a.next;
		}
		
		return newHead;
	}
    
    
    public static ListNode subtract(ListNode head) {     
        if(head == null || head.next == null) return head;
	    
        ListNode rhead = null;
    	ListNode slow = head;
    	
    	int i = 0;
    	while(slow != null){
    		slow = slow.next;
    		i++;
    	}
    	i = i/2;
        
        
    	ListNode rtail = null;
    	ListNode cur = null;
        
        ListNode rev = head;
        rev = reverseList(rev);
    	
    	while(i > 0){
    		cur = new ListNode(rev.val - head.val);
    		
    		if(rtail == null){
    			rtail = cur;
    			rhead = rtail;
    		} else{
    			rtail.next = cur;
    			rtail = cur;
    		}
    		head = head.next;
    		rev = rev.next;
    		
    		i--;
    	}
        rtail.next = head;
    	//printList(rhead);
    
	    return rhead;
	}
    
    
    /* Testcases
    - case 
    Input: 7 1 2 3 4 5 6 7
    Output: 6 -> 4 -> 2 -> 4 -> 5 -> 6 -> 7 -> NULL
    
    - case 
    Input: 8 1 2 3 4 5 6 7 8 
    Output: 7 -> 5 -> 3 -> 1 -> 5 -> 6 -> 7 -> 8 -> NULL
    
    - case 
    Input: 1 3
    Output: 3
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
		
		printList(subtract(head));
	}
}