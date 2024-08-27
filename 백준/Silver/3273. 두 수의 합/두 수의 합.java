import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());
        int left = 0;
        int right = arr.length - 1;
        int cnt = 0;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(sum == x){
                cnt++;
                left++;
                right--;
            }
            else if(sum > x){
                right--;
            }
            else{
                left++;
            }
        }
        System.out.println(cnt);
    }
}