import java.io.*;
import java.util.*;

class Main{
    
    static int[][] arrA;
    static int[][] arrB;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arrA = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                arrA
                [i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        
        st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        
        arrB = new int[m][k];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");           
            for(int j = 0; j < k; j++){
                arrB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                int sum = 0;
                for(int l = 0; l < m; l++){
                    sum += arrA[i][l] * arrB[l][j];
                }
                sb.append(sum).append(' ');
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
    }
}