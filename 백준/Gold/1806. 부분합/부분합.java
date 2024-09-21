import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());    
        }
        
        int left = 0, right = 0, sum = 0, len = Integer.MAX_VALUE;
        while(left <= right && right <= N){    
            if(sum < S){
                sum += arr[right++];
            }
            else if(sum >= S){
                len = Math.min(len, right - left);
                sum -= arr[left++];
            }            
        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}