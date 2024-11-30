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
    public List<TreeNode> generateTrees(int n) {
        if(n < 1){
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            return list;
        }
        return makeBst(1, n);
    }
    
    private ArrayList<TreeNode> makeBst(int start, int end){
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        if(start>end){
            list.add(null);
            return list;
        }
        else if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        else if(start<end){
            for(int i = start; i<=end; i++){
                for(TreeNode lnode: (makeBst(start,i-1))){
                    for(TreeNode rnode: (makeBst(i+1, end))){
                        TreeNode root = new TreeNode(i);
                        root.left = lnode;
                        root.right = rnode;
                        list.add(root);
                    }
                }
            }
            
        }
        return list;
    }
}