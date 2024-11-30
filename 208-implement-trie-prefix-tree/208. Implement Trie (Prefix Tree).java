class Trie {

    HashMap<String, Node> roots;
    HashSet<String> words;
    public Trie() {
        roots= new HashMap<String, Node>();
        words= new HashSet<String>();
    }
    

    public void insert(String word) {
        if(words.contains(word)){     
        }
        else{
            words.add(word);
            String firstLet = word.substring(0,1);
            Node curr;
            if(roots.containsKey(firstLet)){
                 curr = roots.get(firstLet);
            }
            else{
                curr = new Node(firstLet);
                roots.put(firstLet, curr);
            }
            for(int i = 1; i<word.length(); i++){
                String c = word.substring(i,i+1);
                if(curr.next.containsKey(c)){
                    curr = curr.next.get(c);
                }
                else{
                    Node n = new Node(c);
                    curr.next.put(c, n);
                    curr = n;
                }
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(words.contains(word)){
            return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(words.contains(prefix)){
            return true;
        }
        if(roots.containsKey(prefix.substring(0,1))){
            Node curr = roots.get(prefix.substring(0,1));
            for(int i = 1; i<prefix.length(); i++){
                String c = prefix.substring(i,i+1);
                if(curr.next.containsKey(c)){
                    curr = curr.next.get(c);
                }
                else{
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    
    class Node{
    String letter;
    HashMap<String, Node> next;
    public Node(String letter){
        this.letter = letter;
        next = new HashMap<String, Node>();
    }
    public void addNext(String let, Node n){
        next.put(let, n);
    }
}
}





/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */