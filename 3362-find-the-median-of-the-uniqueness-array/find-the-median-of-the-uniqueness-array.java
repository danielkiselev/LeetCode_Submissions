class Solution {
    int len;

    public int medianOfUniquenessArray(int[] nums) {
        this.len = nums.length;
        long totalSubarrays = (long) len * (len + 1) / 2; // total number of subarrays

        int left = 1, right = len;
        // Binary search on the uniqueness value
        while (left < right) {
            int mid = (left + right) / 2;
            // Check if count of subarrays with uniqueness ≤ mid is at least half
            if (countSubarraysWithAtMost(nums, mid) * 2 >= totalSubarrays) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Helper to count subarrays where distinct elements ≤ target
    private long countSubarraysWithAtMost(int[] nums, int target) {
        int left = 0, right = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        long count = 0;

        while (right < len) {
            // Increment frequency of current element
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // If distinct count exceeds target, shrink from left
            while (freq.size() > target) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            // Add number of valid subarrays ending at right
            count += right - left + 1;
            right++;
        }
        return count;
    }
}