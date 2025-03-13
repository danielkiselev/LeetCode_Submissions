class Solution {

    public boolean canJump(int[] nums) {
        int currIndex = nums.length - 1;
        for (int i = currIndex - 1; i >= 0; i--) {
            int checkIndex = i;
            int checkNum = nums[i];
            if (currIndex <= checkNum + checkIndex) {
                currIndex = checkIndex;
            }
        }
        if (currIndex == 0) {
            return true;
        }

        return false;

    }
}