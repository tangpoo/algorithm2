import java.io.*;
import java.util.*;

class Main {
    static ArrayList<ArrayList<Integer>> arr;
    static int[] result;
    static int n;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        for (int i = 0; i < arr.size(); i++) {
            Collections.sort(arr.get(i), Collections.reverseOrder());
        }

        count = 1;
        dfs(start);

        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int idx) {
        result[idx] = count;

        for (int i = 0; i < arr.get(idx).size(); i++) {
            int newIdx = arr.get(idx).get(i);

            if (result[newIdx] == 0) {
                count++;
                dfs(newIdx);
            }
        }
    }
}
