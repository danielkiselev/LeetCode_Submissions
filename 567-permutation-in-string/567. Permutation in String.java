class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if (c1.length > c2.length)
            return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        // Count the frequency of characters in s1 and the first window of s2
        for (int i = 0; i < c1.length; i++) {
            s1Count[c1[i] - 'a']++;
            s2Count[c2[i] - 'a']++;
        }

        // Slide the window over s2
        for (int i = 0; i <= c2.length - c1.length; i++) {
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            if(i == c2.length - c1.length){
                return false;
            }

            // Update the window
            s2Count[c2[i] - 'a']--;
            s2Count[c2[i + c1.length] - 'a']++;
        }
        // Check the last window
        return false;

    }
}