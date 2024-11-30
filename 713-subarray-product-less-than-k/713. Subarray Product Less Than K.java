class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ct = 0;
        int prod = 1;
        int sol = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ct == 0) {
                prod = 1;
            } else {
                ct--;
                prod /= nums[i-1];
            }
            for (int j = i + ct; j < nums.length; j++) {
                if (prod * nums[j] < k) {
                    ct++;
                    prod *= nums[j];
                } else break;
            }
            sol += ct;
        }
        return sol;
    }
}