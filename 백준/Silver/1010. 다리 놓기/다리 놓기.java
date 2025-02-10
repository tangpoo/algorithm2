import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(bridge(m, n)).append("\n");
        }

        System.out.println(sb);
    }

    private static int bridge(int n, int m) {
        if (dp[n][m] > 0) {
            return dp[n][m];
        }

        if (n == m || m == 0) {
            return dp[n][m] = 1;
        }

        return dp[n][m] = bridge(n - 1, m) + bridge(n - 1, m - 1);
    }
}