class Solution {
    public int findMinDifference(List<String> timePoints) {
        int [] minPoints = new int [timePoints.size()];
        for(int i = 0; i<minPoints.length;i++){
            String[] tPArray= timePoints.get(i).split(":");
            minPoints[i] = 60*Integer.parseInt(tPArray[0])+Integer.parseInt(tPArray[1]);
        }
        Arrays.sort(minPoints);
        int res = Math.min(1440, (minPoints[0]-minPoints[minPoints.length-1])+1440);
        for(int i = 0; i<minPoints.length-1;i++){
            res = Math.min(res, minPoints[i+1]-minPoints[i]);
        }
        return res;
    }
}