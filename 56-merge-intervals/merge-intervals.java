class Solution {
    public int[][] merge(int[][] intervals) {
        int index = 0;
        int start [] = new int[intervals.length]; 
        int end [] = new int[intervals.length]; 
        for(int i[] : intervals){
            start[index] = i[0];
            end[index] = i[1];
            index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int sCounter = 0;
        int eCounter = 0;
        ArrayList <int []> res = new ArrayList <>();
        while(sCounter<start.length && eCounter<end.length ){
            int currStart = start[sCounter]; 
            int currEnd = end[eCounter]; 
            if((eCounter+1)<end.length && currEnd>=start[(eCounter+1)]){
                eCounter++;
            }
            else{
                int[] temp = new int[2];
                temp[0] =currStart;
                temp[1] =currEnd;
                res.add(temp);
                sCounter = eCounter+1;
                eCounter++;
            }
        }
        int[][] primitiveArray = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            primitiveArray[i] = res.get(i);
        }
        return primitiveArray;
    }
}
