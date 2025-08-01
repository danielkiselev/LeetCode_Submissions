class Solution {

    class Node {
        String letter;
        ArrayList<String> children = new ArrayList<String>();

        public Node(String letter) {
            this.letter = letter;
        }

        public void addChild(String s) {
            children.add(s);
        }
    }

    HashSet<String> visited = new HashSet<String>();
    HashMap<String, Node> graph = new HashMap<String, Node>();

    public String alienOrder(String[] words) {

        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            for (int z = 0; z < curr.length(); z++) {
                String letter = curr.substring(z, z + 1);
                if (graph.containsKey(letter)) {
                    continue;
                } else {
                    Node n = new Node(letter);
                    graph.put(letter, n);
                }
            }
        }
        for (int i = 0; i < (words.length - 1); i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.substring(0, word2.length()).equals(word2)) {
                return "";
            }
            for (int z = 0; z < word1.length(); z++) {
                int word2Sz = word2.length();
                if (z < word2Sz) {
                    String l1 = word1.substring(z, z + 1);
                    String l2 = word2.substring(z, z + 1);
                    if (l1.equals(l2)) {
                        continue;
                    } else {
                        Node n = graph.get(l1);
                        n.addChild(l2);
                        Node test = graph.get(l2);
                        if (test.children.contains(l1)) {
                            return "";
                        }
                        graph.put(l1, n);
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String key : graph.keySet()) {
            if (visited.contains(key)) {
                continue;
            } else {
                Node n = graph.get(key);
                if (n.children.isEmpty()) {
                    visited.add(n.letter);
                    sb.append(n.letter);
                } else {
                    String res = sort(n, 1);
                    if (res.equals("")) {
                        return "";
                    }
                    sb.append(res);
                }
            }
        }
        sb.reverse();
        return sb.toString();
    }

    public String sort(Node n, int depth) {
        if (depth > 26) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (n.children.isEmpty()) {
            sb.append(n.letter);
            visited.add(n.letter);
            return sb.toString();
        }
        for (String child : n.children) {
            if (visited.contains(child)) {

            } else {
                Node childN = graph.get(child);
                String res = sort(childN, depth + 1);
                // System.out.println(res);
                if (res.equals("")) {
                    return "";
                }
                sb.append(res);
            }
        }
        visited.add(n.letter);
        sb.append(n.letter);
        return sb.toString();
    }
}