class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int odd = (m+n) % 2;
        int counter = 0;
        ArrayList <Integer> l1 = new ArrayList <Integer>();
        ArrayList <Integer> l2 = new ArrayList <Integer>();
        for (int i : nums1)
        {
            l1.add(i);
        }
        for (int i : nums2)
        {
            l2.add(i);
        }

        while(true){
            if(odd == 1){
                if(counter+1 == m+n){
                    if(l1.isEmpty()){
                        return l2.get(0);
                    }
                    else{
                        return l1.get(0);
                    }
                }
            }
            if(odd == 0){
                if(counter+2 == m+n){
                    if(l1.isEmpty()){
                        return (double)((double)(l2.get(1))+(double)(l2.get(0)))/2;
                    }
                    if(l2.isEmpty()){
                        return (double)((double)(l1.get(1))+(double)(l1.get(0)))/2;
                    }
                    else{
                        return (double)((double)(l2.get(0))+(double)(l1.get(0)))/2;
                        
                    }
                }
            }

            if(counter%2 == 0){
                if(l1.isEmpty()){
                    l2.remove(0);

                }
                else if(l2.isEmpty()){
                    l1.remove(0);

                }
                else{
                    if((l1.get(0))<(l2.get(0))){
                        l1.remove(0);

                    }
                    else{
                        l2.remove(0);

                    }
                }
            }
            if(counter%2 == 1){
                if(l1.isEmpty()){
                    l2.remove(l2.size()-1);

                }
                else if(l2.isEmpty()){
                    l1.remove(l1.size()-1);

                }
                else{
                    if((l1.get(l1.size()-1))>(l2.get(l2.size()-1))){
                        l1.remove(l1.size()-1);

                    }
                    else{
                        l2.remove(l2.size()-1);

                    }
                }
            }
            counter++;
        }
    }
}