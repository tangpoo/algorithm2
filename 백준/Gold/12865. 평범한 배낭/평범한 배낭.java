import java.io.*;
import java.util.*;

class Main{
    static int[] w;
	static int[] v;
	static Integer[][] dp;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new Integer[N][K + 1];
		w = new int[N];
		v = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(knapsack(N - 1, K));
	}
	
	public static int knapsack(int i, int k) {
		
		if(i < 0) {
			return 0;
		}
		
		if(dp[i][k] == null) {
			if(w[i] > k) {
				dp[i][k] = knapsack(i - 1, k);
			}
			else {
				dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - w[i]) + v[i]);
			}
		}
		return dp[i][k];
	}
}
