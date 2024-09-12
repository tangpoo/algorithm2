import java.io.*;
import java.util.*;
 
class Main{
    
   static int dp[][];
	static int novel[];
	static int sum[];
	static int k;
	
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        while(t --> 0) {
        	k = Integer.parseInt(br.readLine());
        	
        	dp = new int[k + 1][k + 1];
        	novel = new int[k + 1];
        	sum = new int[k + 1];
        	
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i = 1; i <= k; i++) {
        		novel[i] = Integer.parseInt(st.nextToken());
        		sum[i] = sum[i - 1] + novel[i];
        	}
        	
        	algorithm1();
        }
    }
	
	public static void algorithm1() {
		
		for(int n = 1; n <= k; n++) {
			for(int i = 1; i + n <= k; i++) {
				int j = i + n;
				
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int x = i; x < j; x++) {
					
					dp[i][j] = Math.min(dp[i][j],  dp[i][x] + dp[x + 1][j] + sum[j] - sum[i - 1]);
				}
			}
		}
		System.out.println(dp[1][k]);
	}
}