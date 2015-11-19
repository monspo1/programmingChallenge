/* For HackerRank submission
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

// Task 1: Insert a node at the end of a list
Node Insert(Node head,int data) {
    // This is a "method-only" submission. 
    // You only need to complete this method. 
    Node node = head;
    
    while(node.next != null){
        node = node.next;
    }
    
    Node newNode = new Node();
    newNode.data = data;    
    node.next = newNode;

    return head;
}

// Task 2: Insert a node at the front of a list
Node Insert(Node head,int data) {
    // This is a "method-only" submission. 
    // You only need to complete this method. 
    Node newNode = new Node();
    newNode.data = data;    

    if(head != null)
        newNode.next = head;
    
    head = newNode;
    
    return head;
}

// Task: Detect a cycle in a linkedlist
// Output Format 
// return 1 if there is a cycle. Otherwise, return 0. Do NOT print anything to stdout/console.
int HasCycle(Node head) {
    Node slow = new Node();
    Node fast = new Node();
    slow = head;
    fast = head;
    
    while(slow != null && fast != null && fast.next != null ){
        slow = slow.next;
        fast = fast.next.next;
        
        if(slow == fast){
            return 1;
        }
    }
    return 0;
}



/* For Error check (Null pointer exception test ) at Ideone */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static class Node {
	    int data;
	    Node next; 
	
	    public Node(int d){
	        this.data = d; 
	    } 
	    
	} 
	
	static void Insert1(Node head,int data) {
	    Node node = head;
	    while(node.next != null){ 
	        System.out.print(node.data + " ");  
	        node = node.next; 
	    }
	    System.out.print("| " + node.data + " ");  
	    Node newNode = new Node(data);
	    node.next = newNode;
	    //printNode(head);
        
        // Output:
        // Insert1: 1 2 3 4 5 6 | 7 
	}
	
	static void  Insert2(Node head,int data) {
	    Node node = head.next;
	    while(node != null){ 
	        System.out.print(node.data + " ");  
	        node = node.next; 
	    }
	    System.out.print("| " + node.data + " ");  
	    Node newNode = new Node(data);
	    node.next = newNode;
	    
	    // printNode(head);
        // Exception in thread "main" java.lang.NullPointerException at Ideone.Insert2(Main.java:38) 
	}
	
	static void  Insert3(Node head,int data) {
	    Node node = head.next;
	    while(node.next != null){ 
	        System.out.print(node.data + " ");  
	        node = node.next; 
	    }
	    System.out.print("| " + node.data + " ");  
	    Node newNode = new Node(data);
	    node.next = newNode;
	    
	    //printNode(head);
        // Output:
        // Insert3: 2 3 4 5 6 7 | 8 

	}
	
	static void printNode(Node head){
	    Node node = head;
	    
	    while(node != null){
	      System.out.print(node.data + " ");  
	      node = node.next;
	    } 
	}
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		System.out.print"Insert1: ");  
		Insert1(node1, 8);
		System.out.print("\nInsert2: ");
		Insert2(node1, 8);
        System.out.print("\nInsert3: ");
		Insert3(node1, 8);
	}
}