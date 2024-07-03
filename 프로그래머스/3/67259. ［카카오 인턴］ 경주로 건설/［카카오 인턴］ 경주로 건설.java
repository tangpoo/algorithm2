import java.util.*;
class Solution {
    
    static class Node{
        int x, y, dir, cost;
        
        public Node(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    
    static int n;
    static int[][][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        n = board.length;
        visit = new int[n][n][4];                
        
        return bfs(board);
    }
    
    static int bfs(int[][] board){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, -1, 0));
        int minCost = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.x == n-1 && now.y == n-1){
                minCost = Math.min(minCost, now.cost);
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1){
                    continue;
                }
                
                int nextCost = now.cost;
                if(now.dir == -1 || now.dir == i){
                    nextCost += 100;
                }
                else{
                    nextCost += 600;
                }
                
                if(visit[nx][ny][i] == 0 || board[nx][ny] >= nextCost){
                    q.add(new Node(nx, ny, i, nextCost));
                    visit[nx][ny][i] = 1;
                    board[nx][ny] = nextCost;
                }
            }
        }
        return minCost;
    }
}