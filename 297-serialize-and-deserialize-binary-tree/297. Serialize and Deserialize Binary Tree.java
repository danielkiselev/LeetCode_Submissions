/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayDeque<TreeNode> currNodes = new ArrayDeque<TreeNode>();
        if(root == null){
            return "";
        }
        currNodes.offer(root);
        StringBuilder sbDel = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        while(currNodes.size()>0){
            TreeNode curr = currNodes.poll();
            sb.append("H"+Integer.toString(curr.val));
            if(curr.left != null){
                sb.append("L"+Integer.toString(curr.left.val));
                currNodes.offer(curr.left);
            }
            if(curr.right != null){
                sb.append("R"+Integer.toString(curr.right.val));
                currNodes.offer(curr.right);
            }
            sb.append("|");
            sbDel.append("~"+Integer.toString(sb.length()));
        }
        sb.append(sbDel.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    
    
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        char [] cData = data.toCharArray();
        TreeSet<Integer> segments = new TreeSet<Integer>();
        StringBuilder sb1 = new StringBuilder();
        for(int i = data.length()-1; i>=0; i--){
            if(cData[i] == '|'){
                break;
            }
            else if(cData[i] == '~'){
                segments.add(Integer.valueOf(sb1.reverse().toString()));
                sb1 = new StringBuilder();
            }
            else{
                sb1.append(cData[i]);
            }
        }
        int prevSeg = 0;
        HashMap<Integer, TreeNode> nodes = new HashMap<Integer, TreeNode>();
        TreeNode res = null;
        for(Integer endSeg:segments){
            StringBuilder sb = new StringBuilder();
            TreeNode h = null;
            TreeNode l = null;
            TreeNode r = null;
            int status = -1;//0head, 1l, 2r
            for(int i = prevSeg; i<endSeg-1; i++){
                char c = cData[i];
                if(c == 'H'){
                    status = 0;
                    continue;
                }
                else if(c == 'L'){
                    if(status == 0){
                        int key = Integer.valueOf(sb.toString());
                        if(nodes.containsKey(key)){
                            h = nodes.get(key);
                        }
                        else{
                            h = new TreeNode(key);
                            nodes.put(key, h);
                        }
                    }
                    sb = new StringBuilder();
                    status = 1;
                }
                else if(c == 'R'){
                    if(status == 0){
                        int key = Integer.valueOf(sb.toString());
                        if(nodes.containsKey(key)){
                            h = nodes.get(key);
                        }
                        else{
                            h = new TreeNode(key);
                            nodes.put(key, h);
                        }
                    }
                    else if(status == 1){
                        int key = Integer.valueOf(sb.toString());
                        if(nodes.containsKey(key)){
                            l = nodes.get(key);
                        }
                        else{
                            l = new TreeNode(key);
                            nodes.put(key, h);
                        }
                    }
                    sb = new StringBuilder();
                    status = 2;
                }
                else{
                    sb.append(c);
                }
            }
            if(status == 0){
                int key = Integer.valueOf(sb.toString());
                if(nodes.containsKey(key)){
                    h = nodes.get(key);
                }
                else{
                    h = new TreeNode(key);
                    nodes.put(key, h);
                }
            }
            else if(status == 1){
                int key = Integer.valueOf(sb.toString());
                if(nodes.containsKey(key)){
                    l = nodes.get(key);
                }
                else{
                    l = new TreeNode(key);
                    nodes.put(key, l);
                }
            }
            else if(status == 2){
                int key = Integer.valueOf(sb.toString());
                if(nodes.containsKey(key)){
                    r = nodes.get(key);
                }
                else{
                    r = new TreeNode(key);
                    nodes.put(key, r);
                }
            }
            if(h != null){
                if(l != null){
                    h.left = l;
                }
                if(r != null){
                    h.right = r;
                }
                if(res == null){
                    res = h;
                }
            }
            prevSeg = endSeg;
            // TreeNode n = new TreeNode();
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));