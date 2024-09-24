import java.io.*;
import java.util.*;

class Main{
    
    static int n;
    static int[] dist;
    static boolean[] visit;
    static ArrayList<Node>[] list;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            list = new ArrayList[n+1];
            for(int i = 0; i < n+1; i++){
                list[i] = new ArrayList<Node>();
            }
            
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                
                list[a].add(new Node(b, w));
                list[b].add(new Node(a, w));
            }
            
            int[] dest = new int[t];
            for(int i = 0; i < t; i++){
                dest[i] = Integer.parseInt(br.readLine());
            }
            
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int e : dest){
                long ans1 = dijkstra(s, e);
                long ans2 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, e);
                long ans3 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, e);
                
                if(Math.min(ans2, ans3) == ans1){
                    pq.add(e);
                }
            }
            while(!pq.isEmpty()) {
            	sb.append(pq.poll() + " ");
            }
            sb.append('\n');
        } 
        System.out.println(sb);
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        visit = new boolean[n + 1];
        dist = new int[n + 1];
        q.add(new Node(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
              
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(visit[now.b]) continue;
            visit[now.b] = true; 
            
            for(Node next : list[now.b]){
                if(dist[next.b] > now.w + next.w){
                    dist[next.b] = now.w + next.w;
                    q.add(new Node(next.b, dist[next.b]));
                }
            }
            
        }
        
        return dist[end];
    }
}

class Node{
    int b, w;
    
    public Node(int b, int w){
        this.b = b;
        this.w = w;
    }
}
              