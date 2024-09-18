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
        int[] answer = new int[2];
        int left = 0, right = arr.length - 1, min = Integer.MAX_VALUE;
        while(left < right){
            int sum = arr[left] + arr[right];
            
            if(min > Math.abs(sum)) {
            	min = Math.abs(sum);
            	
            	answer[0] = arr[left];
            	answer[1] = arr[right];
            	
            	if(sum == 0) break;
            }
            
            if(sum > 0){
                right--;
            }
            else{
                left++;
            }
        }
        
        System.out.println(answer[0] + " " + answer[1]);
    }
}