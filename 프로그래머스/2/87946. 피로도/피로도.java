import java.util.*;
class Solution {
    
    static int count = 0;
    static boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return count;
    }
    
    public static int dfs(int k, int[][] dungeons, int depth){  
        for(int i = 0; i < dungeons.length; i++){
            if(visit[i] || dungeons[i][0] > k){
                continue;
            }
            
            visit[i] = true;
            dfs(k - dungeons[i][1], dungeons, depth + 1);
            visit[i] = false;
        }
        return count = Math.max(count, depth);
    }
}