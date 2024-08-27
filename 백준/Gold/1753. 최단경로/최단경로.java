import java.io.*;
import java.util.*;

class Main{
    
    static class Node{
        int v, cost;
        
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    
    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int[] dist;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());        
        int k = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[v + 1];
        dist = new int[v + 1];
        visit = new boolean[v + 1];
        
        for(int i = 1; i <= v; i++){
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph[a].add(new Node(b, w));
        }
        
        dijkstra(k);
        
        for(int i = 1; i <= v; i++){
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }
    
    static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        dist[start] = 0;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(!visit[now.v]){
                visit[now.v] = true;
            }
            
            for(Node next : graph[now.v]){
                if(!visit[next.v] && dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}