class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty string has 1 way to decode
        dp[1] = s.charAt(0) == '0' ? 0 : 1; // Single character case

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1]; // Single digit decoding
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2]; // Two-digit decoding
            }
        }
        return dp[n];
    }
}
