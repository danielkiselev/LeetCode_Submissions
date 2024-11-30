class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> hm = new HashMap <Integer, Integer>();
        HashMap <Integer, ArrayList<Integer> > hmCount = new HashMap <Integer, ArrayList<Integer>>();
        Arrays.sort(nums);
        ArrayList <Integer> resL = new ArrayList<Integer>();
        for(int i= 0; i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        for(Integer i : hm.keySet()){
            int val = hm.get(i);
            if(hmCount.containsKey(val)){
                ArrayList <Integer> tempL = new ArrayList<Integer>();
                tempL = hmCount.get(val);
                tempL.add(i);
                hmCount.put(val,tempL);
            }else{
                ArrayList <Integer> tempL = new ArrayList<Integer>();
                tempL.add(i);
                hmCount.put(val, tempL);
            }
        }
        int []res = new int[nums.length];
        int counter = 0;
        for(Integer i : hmCount.keySet()){
            res[counter] = i;
            counter++;
        }
        Arrays.sort(res);
        int count = 0;
        for(int i = 0; i<k; i++){
            int key = res[nums.length-(i+1)];
            for(Integer z : hmCount.get(key)){
                resL.add(z);
                count++;
                if(count == k){
                    return resL;
                }
            }
        }
        return resL;
    }
}