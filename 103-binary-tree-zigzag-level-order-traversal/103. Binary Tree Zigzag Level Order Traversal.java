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
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    HashMap <Integer, ArrayList<Integer>> hm = new HashMap <Integer, ArrayList<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return res;
        }
        else{
            ArrayList<Integer> locRes = new ArrayList<Integer>();
            int t = trav(root,1);
            locRes.add(t);
            res.add(0, locRes);
            for(Integer i : hm.keySet()){
                res.add(hm.get(i));
            }
        }
        return res;
    }
    
    public int trav (TreeNode n, int level){
        ArrayList<Integer> locRes = new ArrayList<Integer>();
        System.out.println(level+"  "+ n.val);
        if(level%2 ==1){
            if(n.right!=null){
                int t = trav(n.right,level+1);
                locRes.add(t);
            }
            if(n.left!=null){
                int t = trav(n.left,level+1);
                locRes.add(t);
            }
        }
        else if(level%2==0){
            if(n.left!=null){
                int t = trav(n.left,level+1);
                locRes.add(t);
            }

            if(n.right!=null){
                int t = trav(n.right,level+1);
                locRes.add(t);
            }
        }
        if(!locRes.isEmpty()){
    
                if(hm.containsKey(level)){
                            if(level%2==0){
                    ArrayList<Integer> locRes1 = new ArrayList<Integer>();
                    locRes1 = hm.get(level);
                    for(Integer i: locRes1){
                        locRes.add(i);
                    }
                    System.out.println(locRes);
                    hm.put(level, locRes);
                }
            }
         
                if(hm.containsKey(level)){
                if(level%2==1){
                    ArrayList<Integer> locRes1 = new ArrayList<Integer>();
                    locRes1 = hm.get(level);
                    for(Integer i: locRes1){
                        locRes.add(i);
                    }
                    System.out.println(locRes+ "1");
                    hm.put(level, locRes);
                }
            }

            else{
                System.out.println(locRes);
                hm.put(level, locRes);
            }
            
        }
        return n.val;
    }
}