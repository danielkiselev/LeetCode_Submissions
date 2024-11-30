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
    
       class CompStart implements Comparator<Interval> {  
     @Override  
     public int compare(Interval a, Interval b) {  
       return a.start-b.start;  
     }  
   }
    
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new CompStart());  
        PriorityQueue<Integer> pq=new PriorityQueue<>();  
        for (int i=0; i<intervals.length; i++) {
            if (i>0 && intervals[i].start>=pq.peek()){
                pq.poll();
            }   
                pq.add(intervals[i].end);  
            }  
        return pq.size();  
  
        
    }
}