
class Solution {
          
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int n, m;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1],0 , board).cnt;
    }        
    
    static Node dfs(int x1, int y1, int x2, int y2, int depth, int[][] board){
        boolean win = false;
        int minCount = 5 * 5;
        int maxCount = depth;
        
        if(board[x1][y1] == 1){
            for(int i = 0; i < 4; i++){
                int nx = x1 + dir[i][0];
                int ny = y1 + dir[i][1];
                
                if(check(nx, ny, board)){
                    board[x1][y1] = 0;
                    Node d = dfs(x2, y2, nx, ny, depth + 1, board);
                    win |= !d.win;
                    
                    if(!d.win) minCount = Math.min(minCount, d.cnt);
                    else maxCount = Math.max(maxCount, d.cnt);
                    
                    board[x1][y1] = 1;
                }
            }
        }
        
        return new Node(win, win ? minCount : maxCount);
    }
    
    static boolean check(int x, int y, int[][] board){
        if(x < 0 || y < 0 || x >= n || y >= m || board[x][y] == 0) return false;
        return true;
    }
}
class Node{
    boolean win;
    int cnt;
    
    public Node(boolean win, int cnt){
        this.win = win;
        this.cnt = cnt;
    }
}