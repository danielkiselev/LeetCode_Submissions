class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int res = 0;
        if (n <= 1) {
            return res;
        }
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
        int prev = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] curr = intervals[i];
            int start = curr[0];
            int end = curr[1];
            if (start >= prev) {
                prev = end;
            } else {
                res ++;
            }
        }
        return res;
    }
}