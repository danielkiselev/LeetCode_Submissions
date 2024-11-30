class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] - 10 >= 0) {
                digits[i] = digits[i] - 10;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (carry != 0) {
            int res[] = new int[digits.length + 1];
            res[0] = carry;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }
}