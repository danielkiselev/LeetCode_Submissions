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
    ArrayList <List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList <List<Integer>>();
        if(root == null){
            return res;
        }
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        trav(root, sum, sumList);
        return res;
        
        
    }
    
    private void trav(TreeNode curr, int sum, ArrayList<Integer> sumList){
        sum-=curr.val;
        sumList.add(curr.val);
        if((sum == 0) &&(curr.left == null) &&(curr.right == null)){
            res.add(sumList);
            return;
        }
        else{
            if(curr.left != null){
                ArrayList<Integer> sumList1 = new ArrayList<Integer>(sumList);
                trav(curr.left, sum, sumList1);
            }
            if(curr.right != null){
                ArrayList<Integer> sumList1 = new ArrayList<Integer>(sumList);
                trav(curr.right, sum, sumList1);
            }
        }
    }
}