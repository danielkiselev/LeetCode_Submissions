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
    int min;
    int max;
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return root;
        }
        min = L;
        max = R;
        if(root.val>max || root.val<min){
            TreeNode curr = root;
            while(true){
                if(curr.val>max){
                    if(curr.left.val<=curr.val){
                        curr = curr.left;
                    }
                    else{
                        return null;
                    }
                }
                else if(curr.val<min){
                    if(curr.right.val>=curr.val){
                        curr = curr.right;
                    }
                    else{
                        return null;
                    }
                }
                if(curr.val>=min && curr.val<=max){
                    return Cutter(curr);
                }
            }
        }
        else{
            return Cutter(root);            
        }

        
        
    }
    
    private TreeNode Cutter(TreeNode curr){
        if(curr.left == null){
            
        }
        else{
            if(curr.left.val<min){
                if(curr.left.right == null){
                    curr.left = null;
                }
                else{
                    curr.left = curr.left.right;
                    Cutter(curr);
                }
            }
            else{
                curr.left = Cutter(curr.left);
            }
        }
        
        if(curr.right == null){
            
        }
        else{
            if(curr.right.val>max){
                if(curr.right.left == null){
                    curr.right = null;
                }
                else{
                    curr.right = curr.right.left;
                    Cutter(curr);
                }
            }
            else{
                curr.right = Cutter(curr.right);
            }
        }
        return curr;
    }
}