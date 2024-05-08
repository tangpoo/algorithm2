import java.util.*;
class Solution {
    
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int[][] dp = new int[k][n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
            list[i].add(i);
        }
        
        for(int i = 0; i < m; i++){
            int a = edge_list[i][0];
            int b = edge_list[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        for(int i = 0; i < k; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = 1001;
            }
        }
        dp[0][gps_log[0]] = 0;
        
        for(int i = 0; i < k - 1; i++){
            for(int j = 1; j <= n; j++){
                if(dp[i][j] == 1001) continue;
                
                for(int l = 0; l < list[j].size(); l++){
                    int next = list[j].get(l);
                    
                    int nv = 0;
                    if(gps_log[i+1] != next) nv = 1;
                    
                    dp[i+1][next] = Math.min(dp[i+1][next], dp[i][j] + nv);
                }
            }
        }
        
        int answer = dp[k-1][gps_log[k-1]];
        
        return answer == 1001 ? -1 : answer;
    }
}