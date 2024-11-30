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
    public int eraseOverlapIntervals(Interval[] intervals) {
        int count = intervals.length;
        HashMap<Integer,  ArrayList<Integer>> hm = new HashMap<Integer,  ArrayList<Integer>>();
        int indexArr [] = new int[count];
        //ArrayList<Integer>> [] indexArr = new ArrayList<Integer>> [count];
        int res = 0;
        for(int i  = 0; i<count; i++){
            Interval curr = intervals[i];
            Boolean valid = true;
            int start = curr.start;
            int end = curr.end;
            /*
            if(hm.containsKey(start)&&hm.containsKey(end)){
                valid = false;
            }
            */
            for(int z=start; z<end; z++){
                /*
                if(z==start){
                    if(hm.containsKey(z)){
                        ArrayList <Integer> temp = hm.get(z);
                        temp.add(z);
                        hm.put(z,temp);
                    }
                    else{
                        ArrayList <Integer> temp = new ArrayList<Integer>();
                        temp.add(z);
                        hm.put(z,temp);
                    }
                }
                if(z==end){
                }
                */
                //else{
                    if(hm.containsKey(z)){
                        ArrayList <Integer> temp = hm.get(z);
                        temp.add(i);
                        hm.put(z,temp);
                    }
                    else{
                        ArrayList <Integer> temp = new ArrayList<Integer>();
                        temp.add(i);
                        hm.put(z,temp);
                        //indexArr[x] = temp;
                    }
                
               // }
            }
            /*
            if(valid == false){
                res++;
            }
            */
        }
        for(Integer k : hm.keySet()){
            System.out.println(k+"  "+hm.get(k));
        }
        return res;
    }
    
    
}