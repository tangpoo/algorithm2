import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 0){
            System.out.println(0);
            return;
        }

        BigInteger[] dp = new BigInteger[n + 1];

        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);

        for(int i = 2; i <= n ; i++)
            dp[i] = (dp[i - 2].add(dp[i - 1]) );

        System.out.println(dp[n]);
    }
}