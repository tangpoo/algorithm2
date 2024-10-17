import java.io.*;
import java.util.*;

class Main{
    
    static int[] dirX = {0, 0, -1, 1, 0, 0};
    static int[] dirY = {-1, 1, 0, 0, 0, 0};
    static int[] dirZ = {0, 0, 0, 0, -1, 1};
    static int[][][] map;
    static int N, M, H;
    static Queue<tomato> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        map = new int[H][N][M];
        
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                
                for(int k = 0; k < M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    
                    if(map[i][j][k] == 1){
                        q.add(new tomato(i, j, k));
                    }
                }
            }
        }
        System.out.println(bfs());
    }
    
    static int bfs(){
        while(!q.isEmpty()){
            tomato t = q.remove();
            
            int z = t.z;
            int x = t.x;
            int y = t.y;
            
            for(int i = 0; i < 6; i++){
                int nz = z + dirZ[i];
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                
                if(nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H){
                    if(map[nz][nx][ny] == 0){
                        q.add(new tomato(nz, nx, ny));
                        
                        map[nz][nx][ny] = map[z][x][y] + 1;
                    }
                }
            }
        }
        
        int result = Integer.MIN_VALUE;
        
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(map[i][j][k] == 0){
                        return -1;
                    }
                    
                    result = Math.max(result, map[i][j][k]);
                }
            }
        }
        if(result == 1){
            return 0;
        }
        else{
            return result - 1;
        }
    }
    
    static class tomato {
    	int z;
    	int x;
    	int y;
    	
    	public tomato(int z, int x, int y){
    		this.z = z;
    		this.x = x;
    		this.y = y;
    	}
    }
}