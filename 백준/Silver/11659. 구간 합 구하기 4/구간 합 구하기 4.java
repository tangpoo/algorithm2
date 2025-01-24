import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] sum = new long[n + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int indexA = Integer.parseInt(st.nextToken());
            int indexB = Integer.parseInt(st.nextToken());
            
            System.out.println(sum[indexB] - sum[indexA - 1]);
        }
    }
}
