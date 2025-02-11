import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        dfs(n, m, 1, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int start, int depth) {
        if (m == depth) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(n, m, i + 1, depth + 1);
        }
    }
}