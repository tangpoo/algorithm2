import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static boolean[] visited;
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    private static void dfs(int idx, int depth) {
        if (n / 2 == depth) {
            diff();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += arr[i][j];
                    startTeam += arr[j][i];
                } else if (!visited[i] && !visited[j]){
                    linkTeam += arr[i][j];
                    linkTeam += arr[j][i];
                }
            }
        }

        int diffPoint = Math.abs(startTeam - linkTeam);

        if (diffPoint == 0) {
            System.out.println(0);
            System.exit(0);
        }
        else {
            min = Math.min(min, diffPoint);
        }
    }
}