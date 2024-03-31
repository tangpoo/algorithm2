class Solution {
    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] board, t;
    public int solution(int[][] beginning, int[][] target) {
        n = beginning.length;
        m = beginning[0].length;
        board = new int[n][m];
        
        for(int i = 0; i < n; i++){
            board[i] = beginning[i].clone();
        }
        t = target;
        
        dfs(0, 0);
        
        if(ans == Integer.MAX_VALUE) return -1;        
        
        return ans;
    }
    
    static void dfs(int r, int cnt){
        if(r == m){
            boolean flag = true;
            for(int i = 0; i < n; i++){
                int result = check_col(i);
                
                if(result == -1){
                    flag = false;
                    break;
                }
                cnt += result;
            }
            if(flag){
                ans = Math.min(ans, cnt);
            }
            return;
        }
        
        flip_row(r);
        dfs(r + 1, cnt + 1);
        flip_row(r);
        dfs(r + 1, cnt);
    }
    
    static int check_col(int c){
        int cnt = 0;
        for(int i = 0; i < m; i++){
            if(board[c][i] == t[c][i]) cnt++;
        }
        if(cnt == m) return 0;
        else if(cnt == 0) return 1;
        else return -1; 
    }
    
    static void flip_row(int r){
        for(int i = 0; i < n; i++){
            board[i][r] = board[i][r] == 0 ? 1 : 0;
        }
    }
}