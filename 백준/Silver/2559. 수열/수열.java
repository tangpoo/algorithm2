import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++){
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = k; i <= n; i++){
            max = Math.max(max, arr[i] - arr[i - k]);
        }
        
        System.out.println(max);
    }
}