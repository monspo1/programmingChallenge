// For HackerRank submission 
/* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

// 2 solutions

// --------------------------------------------------------------------
// Solution 1 (Bottom-up approach: Super simple, optimized because it avoids repeated visitings)
// --------------------------------------------------------------------
static Node lca(Node root,int v1,int v2){
    if(root == null) return null;
    if(root.data == v1 || root.data == v2) return root;
    
    Node left = lca(root.left, v1, v2);
    Node right = lca(root.right, v1, v2);
    
    if(left != null && right != null) return root;
    
    return (left == null)? right : left;
}


// --------------------------------------------------------------------
// Solution 2 (Top-down approach: Less optimized due to repeated visits) from CTCI.
// (More optimized version also is in the book)
// --------------------------------------------------------------------
static Node lcaNaive(Node root,int v1,int v2)
{
    if(root == null) return null;

    if(!cover(root, v1) || !cover(root, v2)) return null;
    return lcaHelper(root, v1, v2);
}

static boolean cover(Node root, int val){
    if(root == null) return false;
    if(root.data == val) return true;
    
    return cover(root.left, val) || cover(root.right, val);
}
    
static Node lcaHelper(Node root, int v1, int v2){
    if(root == null) return null;
    if(root.data == v1 || root.data == v2) return root;
    
    boolean is_v1_left = cover(root.left, v1);
    boolean is_v2_left = cover(root.left, v2);
    
    if(is_v1_left != is_v2_left) return root;
    
    Node childSide = is_v1_left ? root.left: root.right;

    return lcaHelper(childSide, v1, v2);
}


