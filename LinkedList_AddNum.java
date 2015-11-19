/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static class ListNode {
	   public int val;
	   public ListNode next;
	   ListNode(int x) { val = x; next = null; }
 	}
 	
	public static void printList(ListNode head){
		while(head != null){
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.print("NULL");
	}
	
	public static int length(ListNode node){
		int count = 0;
		while(node != null){
			node = node.next;
			count++;
		}
		return count;
	}
	
    // No (list --> int) conversion
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    ListNode head = null;
	    ListNode tail = null;
	    
	    int ith = 1;
	    int carry = 0;
	    int tot = 0;
	    
	    while(a != null || b != null){
	        int valA = (a == null)? 0: a.val;
	        int valB = (b == null)? 0: b.val;
	        int cur = (valA + valB) + carry;
	        
	        if(cur >= 10){
	            cur %= 10;
	            carry = 1;
	        } else {
	            carry = 0;
	        }
	        
	        ListNode curNode = new ListNode(cur);
	        if(head == null){
	            head = curNode;
	            tail = head;
	        } else{
	            tail.next = curNode;
	            tail = curNode;
	        }
	        a = (a != null)? a.next : a;
	        b = (b != null)? b.next : b;
	    }
	    if(carry == 1){
	        ListNode extra = new ListNode(1);
	        tail.next = extra;
	    }
	    return head;
	}
    
	public static ListNode addNum(ListNode a, ListNode b){
		int m = length(a);
		int n = length(b);
		
		int totA = 0;
		int totB = 0;
		
		while(a != null){
			int tmp = a.val;
			totA += Math.pow(10, m-1) * tmp;
			m--;
			a = a.next;
		}
		
		while(b != null){
			int tmp =  b.val;
			totB += Math.pow(10, n-1) * tmp;
			n--;
			b = b.next;
		}
		
		int tot = totA + totB;
		ListNode head = null;
		ListNode tail = null;
		
		System.out.print("\nSum: " + tot);
		//System.out.println();
		
		while(tot != 0){
			int c = tot % 10; 
			//System.out.print(c + " ");
			ListNode curNode = new ListNode(c);
			if(head == null){
				head = curNode;
				tail = head;
			} else{
				tail.next = curNode;	
				tail = curNode;
			} 
			tot /= 10;
		}
		
		//System.out.println("tot: " + totA);
		return head;
	}
	
	public static ListNode addNum2(ListNode a, ListNode b){
		int m = length(a);
		int n = length(b);
		
		int totA = 0;
		int totB = 0;
		
		while(a != null){
			int tmp = a.val;
			totA += Math.pow(10, m-1) * tmp;
			m--;
			a = a.next;
		}
		
		while(b != null){
			int tmp =  b.val;
			totB += Math.pow(10, n-1) * tmp;
			n--;
			b = b.next;
		}
		
		int tot = totA + totB;
		ListNode head = null;
		ListNode tail = null;
		//System.out.println();
		/*
		int ith = 1;
		int tmpSum = tot;
		while(tot != 0){ tot /= 10; ith++; }
		//*/
		while(tot != 0){
			int c = tot % 10; 
			//System.out.print(c + " ");
			ListNode curNode = new ListNode(c);
			if(head == null){
				head = curNode;
				tail = head;
			} else{
				head = curNode;	
				head.next = tail;
				tail = head;
			} 
			tot /= 10;
		}
		
		//System.out.println("tot: " + totA);
		return head;
	}
    
    /* Method name: addTwoNumbers
     * Input: reversed list of integer (Integer 342 --> List: 2 -> 4 -> 3)
     * Output: Sum of two reversed list (sum of original integer) in reverse order
    //*/
    public static ListNode addTwoNumbers2(ListNode a, ListNode b){
		
		int totA = 0;
		int totB = 0;
		int ia = 1, ib = 1;
		while(a != null){
			totA += a.val * ia;
			a = a.next;
			ia *= 10;
		}
		
		while(b != null){
			totB += b.val * ib;
			b = b.next;
			ib *= 10;
		}
		int tot = totA + totB;
		System.out.println("\ntotA: " + totA + " | totB: " + totB + " = tot: " + tot);
		
		ListNode head = null;
		ListNode tail = null;
		while(tot != 0){
			int c = tot % 10;
			ListNode curNode = new ListNode(c);
			if(head == null){
				head = curNode;
				tail = head;
			} else{
				tail.next = curNode;
				tail = curNode;
			}
			tot /= 10;
		}
		return head;
	}
	
	
    /* Sample Input: 
    *Input 1:
    3 7 3 7
    3 4 8 9
    
    *Input 2:
    0
    1 3
    
    * Input 3:
    4 1 3 4 9 
    5 9 9 9 9 9 
    Output (addNum): 8 -> 4 -> 3 -> 1 -> 0 -> 1
    Output (addNum2): 1 -> 0 -> 1 -> 3 -> 4 -> 8
    Output (addNumbers): 0 -> 3 -> 4 -> 9 -> 0 -> 1 
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
		
		n = sc.nextInt();
		System.out.println();
		ListNode b = new ListNode(0);
		prev = null;
		
		for(int i = 0; i < n; i++){
			int v = sc.nextInt();
			ListNode cur = new ListNode(v);
			if(i == 0) b = cur;
			if(i > 0) prev.next = cur;
			prev = cur; 
		}
		printList(b);
		
		ListNode res = addNum(head, b);
		System.out.print("\nRes1: ");
		printList(res);
		
		res = addNum2(head, b);
		System.out.print("\nRes2: ");
		printList(res);
	}
}