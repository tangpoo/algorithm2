import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pisano = 1500000;
        long n = Long.parseLong(br.readLine()) % pisano;
        long[] dp = new long[pisano + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= pisano ; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000;
        }

        System.out.println(dp[(int)n]);
    }
}