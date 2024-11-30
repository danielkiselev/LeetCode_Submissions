class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double d1 = Math.sqrt(   ((p1[0]-p2[0])*(p1[0]-p2[0])) + ((p1[1]-p2[1])*(p1[1]-p2[1]))   );//1,2
        double d2 = Math.sqrt(   ((p3[0]-p2[0])*(p3[0]-p2[0])) + ((p3[1]-p2[1])*(p3[1]-p2[1]))   );//2,3
        double d3 = Math.sqrt(   ((p1[0]-p3[0])*(p1[0]-p3[0])) + ((p1[1]-p3[1])*(p1[1]-p3[1]))   );//1,3
        if(d1 == 0||d2 ==0||d3 ==0){
            return false;
        }

        if(d1 == d2){//1,3
                double d4 = Math.sqrt(   ((p3[0]-p4[0])*(p3[0]-p4[0])) + ((p3[1]-p4[1])*(p3[1]-p4[1]))   );//4,3
                double d5 = Math.sqrt(   ((p1[0]-p4[0])*(p1[0]-p4[0])) + ((p1[1]-p4[1])*(p1[1]-p4[1]))   );//1,4
                double d6 = Math.sqrt(   ((p2[0]-p4[0])*(p2[0]-p4[0])) + ((p2[1]-p4[1])*(p2[1]-p4[1]))   );//1,4

                if(d4 == d5 && d2 == d4 && d6  == d3){
                    return true;
                }
            
            
        }
        else if(d1 == d3){//2,3

                double d4 = Math.sqrt(   ((p3[0]-p4[0])*(p3[0]-p4[0])) + ((p3[1]-p4[1])*(p3[1]-p4[1]))   );//4,3
                double d5 = Math.sqrt(   ((p2[0]-p4[0])*(p2[0]-p4[0])) + ((p2[1]-p4[1])*(p2[1]-p4[1]))   );//2,4
                double d6 = Math.sqrt(   ((p1[0]-p4[0])*(p1[0]-p4[0])) + ((p1[1]-p4[1])*(p1[1]-p4[1]))   );//1,4

                if(d4 == d5 && d1 == d4 && d6  == d2){
                    return true;
                }
            
        }
        else if(d2 == d3){//1,2

                double d4 = Math.sqrt(   ((p2[0]-p4[0])*(p2[0]-p4[0])) + ((p2[1]-p4[1])*(p2[1]-p4[1]))   );//4,2
                double d5 = Math.sqrt(   ((p1[0]-p4[0])*(p1[0]-p4[0])) + ((p1[1]-p4[1])*(p1[1]-p4[1]))   );//1,4
                double d6 = Math.sqrt(   ((p3[0]-p4[0])*(p3[0]-p4[0])) + ((p3[1]-p4[1])*(p3[1]-p4[1]))   );//1,4
                if(d4 == d5 && d2 == d4 && d6  == d1){
                    return true;
                }
            
        }
        return false;
        
        
        
        
        
    }

}