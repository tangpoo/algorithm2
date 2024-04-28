class Solution {
    
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long rs = x, re = x, cs = y, ce = y;
        
        for(int i = queries.length - 1; i >= 0; i--){
            int order = queries[i][0];
            int dx = queries[i][1];
            
            if(order == 0){
                if(cs > 0) cs += dx;
                ce = Math.min(m - 1, ce + dx);
            }
            else if(order == 1){
                if(ce < m - 1) ce -= dx;
                cs = Math.max(0, cs - dx);
            }
            else if(order == 2){
                if(rs > 0) rs += dx;
                re = Math.min(n - 1, re + dx);
            }
            else{
                if(re < n - 1) re -= dx;
                rs = Math.max(0, rs - dx);
            }
            
            if(re < 0 || rs >= n || ce < 0 || cs >= m) return 0;
        }
        return (re - rs + 1) * (ce - cs + 1);
    }
}