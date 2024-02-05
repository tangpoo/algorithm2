import java.io.*;
import java.util.*;

class Main{
    
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int holeX, holeY;
    static Node blue, red;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        
        for(int i = 0; i < N; i++){
            String str = br.readLine();

            for(int j = 0; j < M; j++){
                board[i][j] = str.charAt(j);
                
                if(board[i][j] == 'B'){
                    blue = new Node(0, 0, i, j, 0);
                }
                else if(board[i][j] == 'R'){
                    red = new Node(i, j, 0, 0, 0);
                }
                else if(board[i][j] == 'O'){
                    holeX = i;
                    holeY = j;
                }
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(red.rx, red.ry, blue.bx, blue.by, 1));
        visited[red.rx][red.ry][blue.bx][blue.by] = true;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            
            int rx = node.rx;
            int ry = node.ry;
            int bx = node.bx;
            int by = node.by;
            int cnt = node.cnt;
            
            if(cnt > 10){
                return -1;
            }
            
            for(int i = 0; i < 4; i++){
                int n_rx = rx;
                int n_ry = ry;
                int n_bx = bx;
                int n_by = by;
                
                boolean isRedHole = false;
                boolean isBlueHole = false;
                
                while(board[n_rx + dx[i]][n_ry + dy[i]] != '#'){
                    n_rx += dx[i];
                    n_ry += dy[i];
                    
                    if(n_rx == holeX && n_ry == holeY){
                        isRedHole = true;
                        break;
                    }
                }
                while(board[n_bx + dx[i]][n_by + dy[i]] != '#'){
                    n_bx += dx[i];
                    n_by += dy[i];
                    
                    if(n_bx == holeX && n_by == holeY){
                        isBlueHole = true;
                        break;
                    }
                }
                if(isBlueHole == true){
                    continue;
                }
                if(isRedHole && !isBlueHole){
                    return cnt;
                }
                if(n_rx == n_bx && n_ry == n_by){
                    if(i == 0){
                        if(rx > bx) n_rx -= dx[i];
                        else n_bx -= dx[i];
                    }
                    else if(i == 1){
                        if(ry < by) n_ry -= dy[i];
                        else n_by -= dy[i];
                    }
                    else if(i == 2){
                        if(rx < bx) n_rx -= dx[i];
                        else n_bx -= dx[i];
                    }
                    else if(i == 3){
                        if(ry > by) n_ry -= dy[i];
                        else n_by -= dy[i];
                    }
                }
                if(!visited[n_rx][n_ry][n_bx][n_by]){
                    visited[n_rx][n_ry][n_bx][n_by] = true;
                    q.add(new Node(n_rx, n_ry, n_bx, n_by, cnt + 1));                   
                }
            }
        }
        return -1;
    }   
}
class Node{
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;
    
    public Node(int rx, int ry, int bx, int by, int cnt){
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}
