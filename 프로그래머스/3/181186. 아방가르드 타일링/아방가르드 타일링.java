class Solution {
    public int solution(int n) {
        int MOD = 1000000007;
        long[] dp = new long[100001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        dp[4] = 23;
        dp[5] = dp[4] + dp[3] * 2 + dp[2] * 5 + dp[1] * 2 + dp[0] * 2;
        
        for(int i = 6; i <= n; i++){
            dp[i] = (dp[i-1] + (dp[i-2] * 2) % MOD + (dp[i-3] * 6) % MOD + dp[i-4] % MOD - dp[i-6] % MOD + MOD) % MOD;
        }
        return (int)(dp[n] % MOD);
    }
}