class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap <Integer, Integer> hm = new HashMap <Integer, Integer>();
        for(int i = 0; i<B.length; i++){
            hm.put(B[i], i);
        }
        for(int i = 0; i<A.length; i++){
            A[i] = hm.get(A[i]);
        }
        return A;
        
        
    }
}