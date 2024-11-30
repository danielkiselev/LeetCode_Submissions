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
    HashMap <Integer,ArrayList<Integer>> hm = new HashMap <Integer,ArrayList<Integer>>();//level, list of values
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if(root == null){
            return res;
        }
        trav(root, 0);
        for(Integer currLevel:hm.keySet()){
            res.add(hm.get(currLevel));
        }
        return res;
    }
    
    private void trav(TreeNode curr, int level){
        if(hm.containsKey(level)){
            ArrayList<Integer> temp = hm.get(level);
            temp.add(curr.val);
            hm.put(level, temp);
        }
        else{
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(curr.val);
            hm.put(level, temp);
        }
        if(curr.left == null){
        }
        else{
            trav(curr.left, level+1);
        }
        if(curr.right == null){
        }
        else{
            trav(curr.right, level+1);
        }
    }
}