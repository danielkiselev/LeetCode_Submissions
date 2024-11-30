class Solution {
    public int hIndex(int[] citations) {
        int papers = citations.length;
        if(papers == 0){
            return 0;
        }
        Arrays.sort(citations);
        int max = 0;
        for(int i = 0; i<papers; i++){
            if(papers-citations[i]>i){
                max++;
            }
            else{
                return papers-max;
            }
        }
        return papers-max;
    }
}