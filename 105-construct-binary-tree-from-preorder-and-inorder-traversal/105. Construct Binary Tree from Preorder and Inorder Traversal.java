/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap <Integer, Integer>  hm = new HashMap <Integer, Integer>();
        if(preorder.length==0){
            return null;
        }
        for(int i = 0; i<inorder.length; i++){
            hm.put(inorder[i],i);
        }
        TreeNode x = new TreeNode(preorder[0]);
        return trav(0,preorder.length-1, x,preorder, inorder, hm);
    }
    
    public TreeNode trav(int min, int max,TreeNode curr,int[] preorder, int[] inorder, HashMap <Integer, Integer> hm){
        if(min>max){
            return null;
        }
        TreeNode n = new TreeNode(preorder[min]);
        System.out.println("parent val"+ n.val);
        System.out.println(min+" " +max);
        

        
        if(min == max){
            System.out.println(inorder[min]+"return");
            TreeNode x = new TreeNode(inorder[min]);
            return x;
        }
    
        
        int mid =  hm.get(preorder[min]);
        System.out.println(hm.get(preorder[min])+"mid");
        //left
        n.left = trav(min, mid-1,curr,preorder, inorder,hm);
        //right
        n.right = trav(mid+1, max,curr, preorder, inorder,hm);
        curr = n;
        
        System.out.println(preorder[min]+"return");
        return curr;

        
    }
}