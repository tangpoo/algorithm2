import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        long lo = 1;
        long hi = k;
        
        while(lo < hi){
            
            long mid = (lo + hi) / 2;
            long count = 0;
            
            for(int i = 1; i <= n; i++){
                count += Math.min(mid / i, n);
            }
            
            if(k <= count){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        System.out.println(lo);
    }
}