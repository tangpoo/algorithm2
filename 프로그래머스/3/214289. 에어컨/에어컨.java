import java.util.*;
class Solution {
    
    static int INF = 987654321;
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int min = INF;
        int[][] dp = new int[onboard.length][55];
        
        for(int i = 0; i < onboard.length; i++){
            Arrays.fill(dp[i], INF);
        }
        
        temperature += 10;
        t1 += 10;
        t2 += 10;
        
        dp[0][temperature] = 0;
        
        for(int i = 0; i < onboard.length - 1; i++){
            for(int j = 0; j < 52; j++){
                if(dp[i][j] == INF) continue;
                
                if(onboard[i] == 1 && (j > t2 || j < t1)) continue;
                
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + a);
                if(j - 1 >= 0)
                    dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + a);
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);
                
                int next_tmp = j;
                
                if(j < temperature)
                    next_tmp++;
                if(j > temperature)
                    next_tmp--;
                
                if(next_tmp >= 0)
                    dp[i + 1][next_tmp] = Math.min(dp[i + 1][next_tmp], dp[i][j]);                
            }
        }
        
        for(int i = 0; i < 52; i++){
            if(onboard[onboard.length - 1] == 1 && (i < t1 || i > t2)) continue;
            min = Math.min(dp[onboard.length - 1][i], min);
        }
        
        return min;
    }
}