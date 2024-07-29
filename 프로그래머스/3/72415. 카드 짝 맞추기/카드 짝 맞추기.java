import java.util.*;
class Solution {
    
    static class Point{
        int x, y, t;
        
        public Point(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    
    static int totalCnt = 0, result = Integer.MAX_VALUE;
    static boolean[] exist = new boolean[7];
    static Point[][] cardPos = new Point[7][2];
    static int[][] map;
    
    public int solution(int[][] board, int r, int c) {
        map = board;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(map[i][j] == 0) continue;
                
                if(!exist[map[i][j]]){
                    exist[map[i][j]] = true;
                    totalCnt++;
                    cardPos[map[i][j]][0] = new Point(i, j, 0);                    
                }
                else{
                    cardPos[map[i][j]][1] = new Point(i, j, 0);
                }
            }
        }
        
        dfs(0, 0, r, c);
        return result;
    }
    
    public void dfs(int idx, int temp, int r, int c){
        if(idx == totalCnt){
            result = Math.min(result, temp);
            return;
        }
        
        for(int i = 1; i <= 6; i++){
            if(!exist[i]) continue;
            
            int moveCnt1 = bfs(r, c, cardPos[i][0].x, cardPos[i][0].y) + bfs(cardPos[i][0].x, cardPos[i][0].y, cardPos[i][1].x, cardPos[i][1].y) + 2;
            
            int moveCnt2 = bfs(r, c, cardPos[i][1].x, cardPos[i][1].y) + bfs(cardPos[i][1].x, cardPos[i][1].y, cardPos[i][0].x, cardPos[i][0].y) + 2;
            
            exist[i] = false;
            map[cardPos[i][0].x][cardPos[i][0].y] = 0;
            map[cardPos[i][1].x][cardPos[i][1].y] = 0;
            if(moveCnt1 < moveCnt2)
                dfs(idx + 1, temp + moveCnt1, cardPos[i][1].x, cardPos[i][1].y);
            else
                dfs(idx + 1, temp + moveCnt2, cardPos[i][0].x, cardPos[i][0].y);
            
            map[cardPos[i][0].x][cardPos[i][0].y] = i;
            map[cardPos[i][1].x][cardPos[i][1].y] = i;
            exist[i] = true;
        }
    }
    
    static int bfs(int sx, int sy, int tx, int ty){
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[4][4];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        q.add(new Point(sx, sy, 0));
        visit[sx][sy] = true;
        while(!q.isEmpty()){
            Point now = q.poll();
            
            if(now.x == tx && now.y == ty)
                return now.t;
            
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || visit[nx][ny])
                    continue;
                
                visit[nx][ny] = true;
                q.add(new Point(nx, ny, now.t + 1));
            }
            
            for(int i = 0; i < 4; i++){
                int nx = now.x, ny = now.y;
                
                while(true){
                    nx += dx[i];
                    ny += dy[i];
                    
                    if(nx == 4 || ny == 4 || nx == -1 || ny == -1){
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    if(map[nx][ny] != 0) break;
                }
                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.add(new Point(nx, ny, now.t + 1));
            }
        }
        return -5;
    }
}