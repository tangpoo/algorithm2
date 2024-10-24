import java.io.*;
import java.util.*;

class Main{
    
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int V, E;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            visited = new int[V + 1];
            
            graph = new ArrayList[V + 1];
            
            for(int i = 0; i <= V; i++) {
            	graph[i] = new ArrayList<Integer>();
            }
            
            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                
                graph[u].add(v);
                graph[v].add(u);
            }
            grouping();
        }
    }
    static void grouping() {
    	Queue<Integer> q = new LinkedList<>();
    	
    	for(int i = 1; i <= V; i++) {
    		if(visited[i] == 0) {
    			q.add(i);
    			visited[i] = 1;
    		}
    		
    		while(!q.isEmpty()) {
    			int now = q.poll();
    			
    			for(int j = 0; j < graph[now].size(); j++) {
    				if(visited[graph[now].get(j)] == 0) {
    					q.add(graph[now].get(j));
    				}
    				
    				if(visited[graph[now].get(j)] == visited[now]) {
    					System.out.println("NO");
    					return;
    				}
    				
    				if(visited[now] == 1 && visited[graph[now].get(j)] == 0) {
    					visited[graph[now].get(j)] = 2;		
    				}
    				else if(visited[now] == 2 && visited[graph[now].get(j)] == 0) {
    					visited[graph[now].get(j)] = 1;
    				}
    			}
    		}
    	}
    	System.out.println("YES");
    }
}
