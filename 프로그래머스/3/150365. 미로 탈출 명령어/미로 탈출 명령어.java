import java.util.*;
import java.lang.*;
class Solution {
    
    static int[][] arr;
    static String answer = null;
    static StringBuilder sb;
    static char[] dir = {'d', 'l', 'r', 'u'};
    static int[] rdir = {1, 0, 0, -1};
    static int[] cdir = {0, -1, 1, 0};
    static int endRow, endCol;
    static int arrRow, arrCol;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        sb = new StringBuilder();
        arr = new int[n][m];
        endRow = r; endCol = c;
        arrRow = n; arrCol = m;
        
        int length = distance(x, y, r, c);
        if((k - length) % 2 == 1 || k < length) return "impossible";
        dfs(x, y, 0, k);
        
        return answer == null ? "impossible" : answer;
    }
    
    static int distance(int x, int y, int r, int c){
        return (int)Math.abs(x - r) + (int)Math.abs(y - c);
    }
    
    static void dfs(int r, int c, int depth, int k){
        if(answer != null) return;
        if(depth + distance(r, c, endRow, endCol) > k) return;
        if(k == depth){
            answer = sb.toString();
            return;
        }
        
        for(int i = 0; i < 4; i++){
            int nextRow = r + rdir[i];
            int nextCol = c + cdir[i];
            
            if(nextRow > 0 && nextCol > 0 && nextRow <= arrRow && nextCol <= arrCol){
                sb.append(dir[i]);
                dfs(nextRow, nextCol, depth + 1, k);
                sb.delete(depth, depth + 1);
            }
        }
    }
}