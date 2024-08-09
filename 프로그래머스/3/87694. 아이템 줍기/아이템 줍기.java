import java.util.*;
class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int answer;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = Integer.MAX_VALUE;
        map = new int[101][101];
        
        for(int i = 0; i < rectangle.length; i++){
            fill(rectangle[i][0] * 2, rectangle[i][1] * 2, rectangle[i][2] * 2, rectangle[i][3] * 2);
        }
        
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return answer / 2;
    }
    
    static void fill(int x1, int y1, int x2, int y2){
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                if(map[i][j] == 2) continue;
                map[i][j] = 2;
                if(i == x1 || i == x2 || j == y1 || j == y2) map[i][j] = 1;
            }
        }
    }
    
    static void bfs(int x, int y, int itemX, int itemY){
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.add(x);
        q.add(y);
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int nowX = q.poll();
            int nowY = q.poll();                        
            
            if(nowX == itemX && nowY == itemY){
                    answer = Math.min(answer, map[nowX][nowY]);
                    continue;
                }         
            
            for(int i = 0; i < 4; i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                
                if(visited[nx][ny] || map[nx][ny] != 1){
                    continue;
                }
                
                map[nx][ny] = map[nowX][nowY] + 1;
                
                visited[nx][ny] = true;               
                q.add(nx);
                q.add(ny);
            }
        }
    }
}