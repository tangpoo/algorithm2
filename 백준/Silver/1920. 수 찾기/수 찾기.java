import java.io.*;
import java.util.*;

class Main{
    static int[] arr;
	
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0){
                sb.append(1).append('\n');
            }
            else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
    
    static int binarySearch(int key){
        
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(key < arr[mid]){
                hi = mid - 1;
            }
            else if(key > arr[mid]){
                lo = mid + 1;
            }
            else return mid;
        }
        
        return -1;
    }
}