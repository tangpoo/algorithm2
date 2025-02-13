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
            Collections.sort(arr.get(i));
        }

        count = 1;
        bfs(start);

        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        result[idx] = count++;

        while(!q.isEmpty()) {
            int node = q.poll();

            for (int val : arr.get(node)) {
                if (result[val] == 0) {
                    q.add(val);
                    result[val] = count++;
                }
            }
        }
    }
}
