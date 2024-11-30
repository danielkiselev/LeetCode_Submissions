class Solution {
      List<List<Integer>> result;

    public List<List<Integer>> threeSum(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, -nums[i], i + 1);
        }
        return result;
    }

    private void twoSum(int[] nums, int target, int indesStartFrom) {
        int l = indesStartFrom, r = nums.length - 1;
        List<Integer> answer = new ArrayList<>();
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target) {
                l++;
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
            } else if (sum > target) {
                r--;
                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            } else {
                answer.add(nums[l]);
                answer.add(nums[r]);
                answer.add(-target);
                result.add(new ArrayList<>(answer));
                answer.clear();
                l++;
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                r--;
                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            }
        }
    }
}