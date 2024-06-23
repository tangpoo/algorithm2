import java.util.*;
class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] turnX = {{-1, 0, -1, 0},{0, 0, 1, 1}};
    static int[][] turnY = {{0, 0, 1, 1},{-1, 0, -1, 0}};
    
    public int solution(int[][] board) {
        int len = board.length;
        int answer = Integer.MAX_VALUE;
        boolean[][][] visit = new boolean[2][101][101];
        Queue<Robot> q = new LinkedList<>();
        q.add(new Robot(0, 0, 0, 0));
        visit[0][0][0] = true;
        
        while(!q.isEmpty()){
            Robot cur = q.poll();
            
            if(cur.dir == 0 && cur.x == len - 1 && cur.y == len - 2){
                answer = Math.min(answer, cur.cnt);
                continue;
            }
            else if(cur.dir == 1 && cur.x == len - 2 && cur.y == len - 1){
                answer = Math.min(answer, cur.cnt);
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if(!check(nx, ny, cur.dir, board)) continue;
                
                if(!visit[cur.dir][nx][ny]){
                    q.add(new Robot(nx, ny, cur.dir, cur.cnt + 1));
                    visit[cur.dir][nx][ny] = true;
                }
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cur.x + turnX[cur.dir][i];
                int ny = cur.y + turnY[cur.dir][i];
                
                int cx = cur.x + dx[i%2];
                int cy = cur.y + dy[i%2];
                
                if(cur.dir == 1){
                    cx = cur.x + dx[i<2 ? i+2 : i];
                    cy = cur.y + dy[i<2 ? i+2 : i];
                }
                int ndir = cur.dir^1;
                
                if(!check(nx, ny, ndir, board) || !check(cx, cy, cur.dir, board)) continue;                                              
                if(!visit[ndir][nx][ny]){
                    q.add(new Robot(nx, ny, ndir, cur.cnt + 1));
                    visit[ndir][nx][ny] = true;
                }
            }
        }
        return answer;
    }
    static boolean check(int x, int y, int dir, int[][] board){
        int len = board.length;
        if(dir == 0){
            if(x < 0 || y < 0 || x >= len || y >= len || y+1 >= len || board[x][y] != 0 || board[x][y + 1] != 0)
                return false;
            return true;
        }
        else{
            if(x < 0 || y < 0 || x >= len || y >= len || x+1 >= len || board[x][y] != 0 || board[x + 1][y] != 0)
                return false;
            return true;
        }
    }
    
    static class Robot{
        int x, y, dir, cnt;
        
        public Robot(int x, int y, int dir , int cnt){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}