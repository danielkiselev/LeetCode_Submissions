class Node{
    String word;
    ArrayList<Node> children;
    ArrayList<String> forms;
    public Node(String word){
        children = new ArrayList<Node>();
        forms = new ArrayList<String>();
        this.word = word;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<String>(wordList);//wordList converted to wordSet.
        if(!wordSet.contains(endWord)){
            return 0;
        }
        if(beginWord.length() == 1){
            return 2;
        }
        HashMap<String, ArrayList<String>> bank = new HashMap<String, ArrayList<String>>();//form, words that have this form
        HashMap<String, Node> wordToNode = new HashMap<String, Node>();//string, node object representation
        wordSet.add(beginWord);//add starting word to the set
        for(String parent : wordSet){//iterate through all words and iterate through each char to put missing char
            Node curr = new Node(parent);
            for(int i = 0;i<parent.length(); i++ ){
                char [] parentArr = parent.toCharArray();
                parentArr[i] = '_';
                String form = String.valueOf(parentArr);
                curr.forms.add(form);
                ArrayList<String> temp = new ArrayList<String>();
                if(bank.containsKey(form)){
                    temp = bank.get(form);
                }
                temp.add(parent);
                bank.put(form,temp);
            }
            wordToNode.put(parent, curr);
        }
        HashSet<Node> active = new HashSet<Node>();//the current parents of bfs
        active.add(wordToNode.get(beginWord));
        int distance = 1;
        while(true){
            distance++;
            HashSet<Node> nextAct = new HashSet<Node>();
            for(Node curr : active){//iterate through parents in bfs
                for(String form : curr.forms){
                    ArrayList<String> potChildren = bank.get(form);//get all possible children and iterate thru
                    for(String child : potChildren){
                        if(wordSet.contains(child)){//ensures we don't revisit nodes
                            Node tempChild = wordToNode.get(child);
                            if(tempChild.word.equals(endWord)){
                                return distance;
                            }
                            nextAct.add(tempChild);
                        }
                    }
                }
                wordSet.remove(curr.word);
            }
            if(nextAct.isEmpty()){
                return 0;
            }
            active = nextAct;
        }
    }
}