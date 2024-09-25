import java.io.*;
import java.util.*;

class Main{
    static class Node{
        int v, w, cost;
        
        public Node(int v, int w, int cost){
            this.v = v;
            this.w = w;
            this.cost = cost;
        }
    }
    
    static int INF = 500 * 100000;
    static long[] dist;
    static ArrayList<Node> graph;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.add(new Node(v, w, cost));
        }
        
        if(bellmanFord(n, m, 1)) {
        	for(int i = 2; i <= n; i++) {
        		sb.append(dist[i] == INF ? -1 : dist[i]).append('\n');
        	}
        }
        else {
        	sb.append(-1).append('\n');
        }
        System.out.println(sb);
    }
    
    static boolean bellmanFord(int n, int m, int start){
        dist = new long[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                Node node = graph.get(j);
                
                if(dist[node.v] != INF && dist[node.w] > dist[node.v] + node.cost){
                    dist[node.w] = dist[node.v] + node.cost;
                }
            }
        }
        for(int i = 0 ; i < m; i++){
            Node node = graph.get(i);
            
            if(dist[node.v] != INF && dist[node.w] > dist[node.v] + node.cost){
                return false;
            }
        }
        return true;
    }
}