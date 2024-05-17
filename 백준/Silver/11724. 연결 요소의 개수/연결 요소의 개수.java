import java.util.*;
import java.io.*;

class Main {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void dfs(int start){
        visited[start] = true;

        for(int to : graph[start]){
            if(!visited[to]){
                dfs(to);
            }
        }
    }
}