class Solution {
    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        char [] sArray = S.toCharArray();
        HashMap<Character, Integer> letterStart = new HashMap<Character, Integer>();
        HashMap<Character, Integer> letterEnd = new HashMap<Character, Integer>();
        ArrayDeque<Character> letterQueue = new ArrayDeque<Character>();
        for(int i = 0; i<S.length(); i++){
            char curr = sArray[i];
            if(letterStart.containsKey(curr)){
                letterEnd.put(curr,i);
            }
            else{
                letterQueue.offer(curr);
                letterStart.put(curr,i);
                letterEnd.put(curr,i);
            }
        }
        while(letterQueue.size()>0){
            char curr = letterQueue.poll();
            int indexStart = letterStart.get(curr);
            int indexEnd = letterEnd.get(curr);
            while(letterQueue.size()>0){
                char next = letterQueue.peek();
                int indexNext = letterStart.get(next);
                if(indexNext<indexEnd){
                    letterQueue.poll();
                    int indexEndNext = letterEnd.get(next);
                    if(indexEndNext>indexEnd){
                        indexEnd = indexEndNext;
                    }
                }
                else{
                    break;
                }
            }
            res.add(1+indexEnd-indexStart);
        }
        return res;
    }
}