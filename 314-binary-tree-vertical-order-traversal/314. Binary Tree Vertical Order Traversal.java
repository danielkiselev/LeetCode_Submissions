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
    
    TreeMap< Integer , ArrayList<Integer>> tMap;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        tMap = new TreeMap <Integer, ArrayList<Integer>>();
        ArrayList<Integer> data = new ArrayList<Integer>();
        data.add(root.val);
        tMap.put(0, data);
        trav(0, root, 0);
        for(Integer key : tMap.keySet()){
            res.add(tMap.get(key));
        }
        
        
        
        return res;
    }
    
    private void trav(int level,TreeNode curr, int offSet){
        if(curr.left != null){
            ArrayList<Integer> data = new ArrayList<Integer>();
            if(tMap.containsKey(offSet-1)){
                data = tMap.get(offSet-1);
            }
            data.add(curr.left.val);
            tMap.put(offSet-1, data);
        }
        if(curr.right != null){
            ArrayList<Integer> data = new ArrayList<Integer>();
            if(tMap.containsKey(offSet+1)){
                data = tMap.get(offSet+1);
            }
            data.add(curr.right.val);
            tMap.put(offSet+1, data);
        }
        if(curr.left != null){
            trav(level+1, curr.left, offSet-1);
        }
        
        if(curr.right != null){
            trav(level+1, curr.right, offSet+1);
        }
        
        
    }
}