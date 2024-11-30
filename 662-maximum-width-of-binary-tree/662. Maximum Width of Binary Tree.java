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
    TreeMap<Integer,ArrayList<Integer>> hm = new TreeMap<Integer,ArrayList<Integer>>();
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        trav(0,root);
        int max = 0;
        for(Integer key : hm.keySet()){
            ArrayList<Integer> local = new ArrayList<Integer>();
            local = hm.get(key);
            Integer start = -1;
            Integer end = -1;
            int index = 0;
            for(Integer v : local){
                if(start == -1 && v != null){
                    start = index;
                }
                else if(v != null){
                    end = index;
                }
                index++;
            }
            System.out.println(local);
            if(end - start >max){
                max = end-start;
            }
        }
        return max+1;
        
        
    }
    
    private void trav(int level,TreeNode curr){
        ArrayList<Integer> local = new ArrayList<Integer>();
        if(hm.containsKey(level)){
            local = hm.get(level);
            if(curr == null){
                local.add(null);
            }
        }
        if(curr != null){
            local.add(curr.val);
        }
        hm.put(level, local);
        if(curr != null && curr.left != null){
            trav(level+1, curr.left);
        }
        else if(hm.containsKey(level+1)){
            trav(level+1, null);
        }
        if(curr != null && curr.right != null){
            trav(level+1, curr.right);
        }
        else if(hm.containsKey(level+1)){
            trav(level+1, null);
        }
        
        
    }
}