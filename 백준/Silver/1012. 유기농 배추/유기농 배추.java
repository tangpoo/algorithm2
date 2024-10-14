import java.io.*;
import java.util.*;

class Main{
    
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int nowX, nowY;
    static int[][] map;
    static boolean[][] check;
    static int N, M;
    static int count;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T --> 0){
            st = new StringTokenizer(br.readLine(), " ");
            
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            map = new int[N][M];
            check = new boolean[N][M];
            
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine(), " ");
                
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                map[y][x] = 1;
            }
            count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1 && check[i][j] == false){
                        count++;
                        dfs(j, i);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
    
    static void dfs(int x, int y){
        check[y][x] = true;
        
        for(int i = 0; i < 4; i++){
            nowX = x + dirX[i];
            nowY = y + dirY[i];
            
            if(Range_check() && check[nowY][nowX] == false && map[nowY][nowX] == 1){                
                dfs(nowX, nowY);
            }
        }
    }
    
    static boolean Range_check(){
        return (nowY >= 0 && nowY < N && nowX >= 0 && nowX < M);
    }
}