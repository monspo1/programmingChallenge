import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static class Node{
        int value;
        int min;
        Node next;
        
        Node(int x){
            value = x;
            next = null;
            min = x;
        }
    }
    
    class MinStack{
        Node head;
        
        public void push(int x){
            if(head == null){
                head = new Node(x);    
            } else{
                Node cur = new Node(x);
                cur.min = Math.min(head.min, x);
                cur.next = head;
                head = cur;
            }
        }
        
        public void pop(){
            if(head == null) return void;
            
            return head.next;
        }
        
        public int top(){
            if(head == null) return Integer.MAX_VALUE;
                
            return head.value;
        }
        
        public int getMin(){
            if(head == null) return Integer.MAX_VALUE;
            
            return head.min;
        }
    }
    
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();         
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
		for(int i = 0; i < n; i++){
    	    arr.add(sc.nextInt());    
		}
	}
}