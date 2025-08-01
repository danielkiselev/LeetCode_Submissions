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
        ArrayList <Integer []> res = new ArrayList <Integer []>();
        while(sCounter<start.length && eCounter<end.length ){
            int currStart = start[sCounter]; 
            int currEnd = end[eCounter]; 
            if((eCounter+1)<end.length && currEnd>=start[(eCounter+1)]){
                eCounter++;
            }
            else{
                Integer[] temp = new Integer[2];
                temp[0] =currStart;
                temp[1] =currEnd;
                res.add(temp);
                sCounter = eCounter+1;
                eCounter++;
            }
        }
        int[][] primitiveArray = new int[res.size()][2];

        // Iterate through the ArrayList and copy elements to the int array
        for (int i = 0; i < res.size(); i++) {
            primitiveArray[i][0] = res.get(i)[0];
            primitiveArray[i][1] = res.get(i)[1];
        }
        return primitiveArray;
    }
}


        // int start [] = new int[intervals.size()]; 
        // int end [] = new int[intervals.size()]; 
        // int index = 0;
        // for(Interval i : intervals){
        //     start[index] = i.start;
        //     end[index] = i.end;
        //     index++;
        // }
        // Arrays.sort(start);
        // Arrays.sort(end);
        // int sCounter = 0;
        // int eCounter = 0;

        // ArrayList <Interval> res = new ArrayList <Interval>();
        // while(sCounter<start.length && eCounter<end.length ){
        //     int currStart = start[sCounter]; 
        //     int currEnd = end[eCounter]; 
        //     if((eCounter+1)<end.length && currEnd>=start[(eCounter+1)]){
        //         eCounter++;
        //     }
        //     else{
        //         Interval temp = new Interval(currStart, currEnd);
        //         res.add(temp);
        //         sCounter = eCounter+1;
        //         eCounter++;
        //     }
        // }
        // return res;
