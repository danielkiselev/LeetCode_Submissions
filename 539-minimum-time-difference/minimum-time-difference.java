class Solution {
    public int findMinDifference(List<String> timePoints) {
        int [] minPoints = new int [timePoints.size()];
        int index = 0;
        for(String tPoint:timePoints){
            String[] tPArray= tPoint.split(":");
            int minutesTP = 60*Integer.parseInt(tPArray[0])+Integer.parseInt(tPArray[1]);
            minPoints[index]= minutesTP;
            index++;
        }
        Arrays.sort(minPoints);
        int res = 1440;
        for(int i = 0; i<minPoints.length-1;i++){
            res = Math.min(res, minPoints[i+1]-minPoints[i]);
        }
        res = Math.min(res, (minPoints[0]-minPoints[minPoints.length-1])+1440);
        return res;
    }
}