import java.io.*;
import java.util.*;

class Main{
    
    static int[][] arr;
    static int n;
    static int MOD = 1000;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        arr = new int[n][n];
        
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }
        
        int[][] result = pow(arr, b);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
    }
    
    static int[][] pow(int[][] A, long exp){
        
        if(exp == 1){
            return A;
        }
        
        int[][] ret = pow(A, exp / 2);
        
        ret = multipul(ret, ret);
        
        if(exp % 2 == 1L){
            return multipul(ret, arr);
        }
        
        return ret;
    }
    
    static int[][] multipul(int[][] o1, int[][] o2){
        
        int[][] ret = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        
        return ret;
    }
}