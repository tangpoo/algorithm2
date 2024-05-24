import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[0] = 0;
        if(n == 0){
            System.out.println(0);
            return;
        }
        dp[1] = 1;

        for(int i = 2; i <= n ; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[n]);
    }
}