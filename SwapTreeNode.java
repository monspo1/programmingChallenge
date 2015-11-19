/* package whatever; // don't place package name! */
//https://www.hackerrank.com/challenges/swap-nodes-algo
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int d){
			this.data = d;
		}
	}
	
	static int height(Node root){
		if(root == null) return 0;
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	static void swapNode(Node root, int h, int curDepth){ // curDepth1.
		if(root == null) return;
		
		Node node = root;
        if(curDepth == h){
            Node tmp = node.right;
            node.right = node.left;
            node.left = tmp;
        } else{
            swapNode(node.left, h, curDepth+1); 
            swapNode(node.right, h, curDepth+1);
        }
	}
	
    static void printNodeSwapped(Node node, int k, int depth, int height, int index){
        int h = height;
        int j = index;
        
        while(h < depth){
        	h = k * j;
        	swapNode(node, h, 1);
        	j++;
        }
        printTreeNode(node);
    }
    
	static void printTreeNode(Node node){
		if(node == null) return;
		
		printTreeNode(node.left);
		System.out.print(node.data + " ");
		printTreeNode(node.right);
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
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);

        /* testcase #01
		node1.left = node2;
		node1.right = node3;
		node3.right = node5;
		node2.right = node4;
        //*/

        //* testcase #02
        node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.left = node5;
		node4.left = node6;
		node5.left = node7;
		node6.right = node9;
		node5.right = node8;
		node8.left = node10;
		node8.right = node11;
        //*/

		int d = height(node1);
        //int k = 2;
        //int h = 0, j = 1;
        /*
        while(h < d){
        	h = k * j;
        	swapNode(node1, h, 1);
        	j++;
        }
        printTreeNode(node1);
        
        System.out.println();
        
        k = 4; 
        h = 0, j = 1;
        while(h < d){
        	h = k * j;
        	swapNode(node1, h, 1);
        	j++;
        }
        printTreeNode(node1);
		//System.out.println("height: " + d);
        //*/
        
        int k = 2;
        printNodeSwapped(node1, k, d, 0, 1);
        System.out.println();
        
        k = 4;
        printNodeSwapped(node1, k, d, 0, 1);
	}   
}

/*
import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int d){
			this.data = d;
		}
	}
	
	static int height(Node root){
		if(root == null) return 0;
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	static void swapNode(Node root, int h, int curDepth){ // curDepth1.
		if(root == null) return;
		
		Node node = root;
        if(curDepth == h){
            Node tmp = node.right;
            node.right = node.left;
            node.left = tmp;
        } else{
            swapNode(node.left, h, curDepth+1); 
            swapNode(node.right, h, curDepth+1);
        }
	}
	
	static void printNodeSwapped(Node node, int k, int depth, int height, int index){
        int h = height;
        int j = index;
        
        while(h < depth){
        	h = k * j;
        	swapNode(node, h, 1);
        	j++;
        }
        printTreeNode(node);
    }
    
	static void printTreeNode(Node node){
		if(node == null) return;
		
		printTreeNode(node.left);
		System.out.print(node.data + " ");
		printTreeNode(node.right);
	}
	
	// Recursive not working.
	static Node createTree(int[] arr, int index){
		if(arr == null || arr.length == 0) return null;
		if(index >= arr.length) return null;
		//if(arr[index] == -1) return null;
		
		Node node = new Node(arr[index]);
		
		if( (2*index+1) < arr.length ){
			node.left = createTree(arr, (2*index+1));
		}
		
		if( (2*index+2) < arr.length ){
			node.right = createTree(arr, (2*index+2));
		}
		
		return node;
	}
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[(2*t+1)];
        arr[0] = 1;
        
        for(int i = 1; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        Node root = createTree(arr, 0);
        printTreeNode(root);
        
        /*
        System.out.println("len: " + arr.length);
        
        while(sc.hasNext()){
        	int k = sc.nextInt();
        	System.out.print("\nk: " + k);	
        }
        //*/
        /*
        int d = height(node1); 
        int k = 2;
        printNodeSwapped(node1, k, d, 0, 1);
        System.out.println();
        
        k = 4;
        printNodeSwapped(node1, k, d, 0, 1);
        //*/
	}
	/* testcase #01
	5
	2 3
	-1 4
	-1 5
	-1 -1
	-1 -1
	1
	2
	//*/
	
	/* testcase #02
	11
	2 3
	4 -1
	5 -1
	6 -1
	7 8
	-1 9
	-1 -1
	10 11
	-1 -1
	-1 -1
	-1 -1
	2
	2
	4
	//*/
}

//*/