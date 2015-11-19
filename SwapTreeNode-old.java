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
		if(node.data != -1) System.out.print(node.data + " ");
		printTreeNode(node.right);
	}
	/*
	static Node createTree(int[] arr, int index, int leftChildIndex){
		if(arr == null || arr.length == 0) return null;
		if(index >= arr.length) return null;

		Node node = new Node(arr[index]);
		if(arr.length == 1) return node;
		
		int li = leftChildIndex;
		
		if(arr[index] != -1){
			node.left = createTree(arr, );
			node.right = 
		}
			
		
		return node;
	}
	//*/
	
	static Node createTree(int[] arr, int index){
		if(arr == null || arr.length == 0) return null;
		if(index >= arr.length) return null;
		
		Node root = new Node(1);
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		
		//*	
		while(!queue.isEmpty()){
			Node node = queue.pop();	
			if(node.data != -1){
				node.left = new Node(arr[++index]);
				if(node.left.data != -1) queue.add(node.left);
				node.right = new Node(arr[++index]);
				if(node.right.data != -1) queue.add(node.right);
			} 
		}
		//*/
		/*
		while(!queue.isEmpty()){
			Node node = queue.pop();
			if(node.data != -1){
				if(arr[index+1] != -1){
					node.left = new Node(arr[++index]);
					queue.add(node.left);
				}
				
				if(arr[index+1] != -1){
					node.right = new Node(arr[++index]);
					queue.add(node.right);
				}
			}
		}
		//*/
	
		return root;
	}
	
	
	/*
	static Node createTreeIterative(int[] arr){
		if(arr == null || arr.length == 0) return null;
		Node node = new Node(arr[0]);
		
		int i = 0;
		
		while(i < arr.length){
			if(arr[i+1] != -1){
				node.left = new Node(arr[i+1]);
			} else{
				node.left = null;
			}
			if(arr[i+1] != -1){
				node.right = new Node(arr[i+2]);	
			} else{
				node.right = null;
			}
		}
		
		return node;
	}
	//*/
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[(2*t+1)];
        arr[0] = 1;
        
        for(int i = 1; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("len: " + arr.length);
        for(int m = 0; m < arr.length; m++){
        	System.out.print(arr[m] + "|");
        }
        System.out.println();
        
        //Node root = createTree(arr, 0, 1);
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
        
        // by RubenzZzZ
        Scanner in = new Scanner(System.in);
	    int treeSize = in.nextInt();
		int[] tree_depth = new int[treeSize +1];
	    int[] tree_left = new int[treeSize +1];
	    int[] tree_right = new int[treeSize +1];
	    
	    for(int i = 1; i <= treeSize; i++){
	        tree_left[i] = in.nextInt();
	        tree_right[i] = in.nextInt();
	    }
	    
	    //Read in swaps
	    int numSwaps = in.nextInt();
	    swaps = new int[numSwaps];
	    for(int i = 0; i < swaps.length; i++){
	        swaps[i] = in.nextInt();
	    }

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