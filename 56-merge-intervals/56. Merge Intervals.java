/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int start [] = new int[intervals.size()]; 
        int end [] = new int[intervals.size()]; 
        int index = 0;
        for(Interval i : intervals){
            start[index] = i.start;
            end[index] = i.end;
            index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int sCounter = 0;
        int eCounter = 0;

        ArrayList <Interval> res = new ArrayList <Interval>();
        while(sCounter<start.length && eCounter<end.length ){
            int currStart = start[sCounter]; 
            int currEnd = end[eCounter]; 
            if((eCounter+1)<end.length && currEnd>=start[(eCounter+1)]){
                eCounter++;
            }
            else{
                Interval temp = new Interval(currStart, currEnd);
                res.add(temp);
                sCounter = eCounter+1;
                eCounter++;
            }
        }
        return res;


    }
}