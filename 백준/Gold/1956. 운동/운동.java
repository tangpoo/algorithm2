import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int INF = 987654321;
        int[][] arr = new int[v+1][v+1];
        
        for(int i = 1; i <= v; i++){
            for(int j = 1; j <= v; j++){               
                if(i != j){
                    arr[i][j] = INF;
                }
            }
        }
        
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            arr[a][b] = Math.min(arr[a][b], w);
        }
        
        for(int k = 1; k <= v; k++){
            for(int i = 1; i <= v; i++){
                for(int j = 1; j <= v; j++){
                    if(i == j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        
        int min = INF;
        for(int i = 1; i <= v; i++){
            for(int j = 1; j <= v; j++){
            	if(i == j) continue;
                if(arr[i][j] != INF && arr[j][i] != INF){
                    min = Math.min(min, arr[i][j] + arr[j][i]);
                }
            }
        }
        
        System.out.println(min == INF ? -1 : min);
    }
}