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
	
    
	public static ListNode rotateRight2(ListNode a, int n) {
		// 나는 문제 다르게 이해해서 k만큼 이동한 후 그 뒤의 리스트를 앞으로, k 왼쪽 리스트를 연결시키는 걸로 풀었음. 
		if(a == null) return a;
		
		ListNode shead = null;
		ListNode tail = null;
		ListNode rhead = null;
		ListNode rtail = null;
        ListNode cur = null;
        int i = 0;
        
		while(a != null){
			cur = new ListNode(a.val);
			if(i <= n){
				if(shead == null){
					shead = cur;
					tail = cur;
				} //*
				else{
					tail.next = cur;
					tail = cur;
				}
				//*/
			} else{
				if(rhead == null){
					rhead = cur;
					rtail = cur;
				} else{
					rtail.next = cur;
					rtail = cur;
				}
			}
			a = a.next;
			i++;
		}
		//System.out.println("rtail.val: "+ rtail.val + " | cur: " + cur.val);
		if(rtail != null) rtail.next = shead;
		else return shead;
		
		return rhead;
	}
	
	
    public static ListNode rotateRightNaive(ListNode head, int k) {
        if(head == null || k == 0) return head;   
        int len = length(head);
        len = k % len; 
        System.out.println("len: " + len);
        
        ListNode rhead = null;
        ListNode rtail = null;
        ListNode shead = null;
        ListNode fast = head;
        ListNode slow = head;
        
        int i = 0;
        while(i <= len ){
            fast = fast.next;
            if(fast == null) fast = head;
            i++;
        }
        shead = head;
        //System.out.println("fast.val: " + fast.val);
        
        while(fast != null){
        	fast = fast.next;
        	slow = slow.next;
        }
        rhead = (slow == null)? null : (slow.next == null? null : slow.next);
        rtail = rhead;
        //slow.next = null;
        if(slow != null) slow.next = null;
        
        //System.out.println("slow.val: " + slow.val + " | rhead.val: " + rhead.val);
        while(rtail != null && rtail.next != null){
        	rtail = rtail.next;
        }
        
        if(rtail != null) rtail.next = shead;
        else return shead;
        
        return rhead;
    }
    
    public static int length(ListNode a){
		int len = 0;
		while(a != null) {
			a = a.next;
			len++;
		}
		return len;
	}
	//3 1 2 3 20000000
	//5 1 2 3 4 5 2
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;   
        int len = length(head);
        int newk = (k > len)? (k % len) : k;
        int slen = len - newk; //slen = slen < 0 ? 0 : slen;
        System.out.println("len: " + len + " | newk: " + newk + " | slen: " + slen);
        
        ListNode rhead = null;
        ListNode rtail = null;
        ListNode shead = null;
        ListNode stail = null;
        ListNode cur = null;
        //ListNode fast = head;
        //ListNode slow = head;
        
        int i = 0; 
        while(head != null){
        	cur = new ListNode(head.val);
        	
            if(i < slen){
            	if(shead == null){
            		shead = cur;
            		stail = cur;
            	} else{
            		stail.next = cur;
            		stail = cur;
            	}
            } else{
            	if(rhead == null){
            		rhead = cur;
            		rtail = cur;
            	} else{
            		rtail.next = cur;
            		rtail = cur;
            	}
            }
            head = head.next;
            i++;
        }
        
        if(rtail != null) rtail.next = shead;
        else return shead;
        
        return rhead;
    }
    
    /* Testcase
    - Testcase #1
    Input: 10 1 2 3 4 5 6 7 8 9 10 7
    Output: 7 -> 8 -> 9 -> 10 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
    
    - Testcase #2
    Input: 1 1 1
    Output: 1 -> NULL
    
    - Testcase #3
    Input: 1 1 0
    Output: 1 -> NULL
    
    - Testcase #4
    Input: 5 1 2 3 4 5 2
    Output:4 -> 5 -> 1 -> 2 -> 3 -> NULL
    
    - Testcase #5
    Input: 3 1 2 3 20000000
    Output: 2 -> 3 -> 1 -> NULL
    
    
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
		
		int k = sc.nextInt();
		
		printList(head);
		
		printList(rotateRight(head, k));
	}
}