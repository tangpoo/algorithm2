import java.io.*;
import java.util.*;

class Main{
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int N, M;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        visited = new int[N + 1];
        
        for(int i = 0; i <= N; i++) {
        	graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	
        	graph.get(A).add(B);
        	graph.get(B).add(A);
        }
        
        for(int i = 1; i <= N; i++) {
        	Collections.sort(graph.get(i));
        }
        
        bfs(R);
        
        for(int i = 1; i <= N; i++) {
        	System.out.println(visited[i]);
        }
    }
    
    static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	int cnt = 1;
    	
    	q.offer(start);
    	visited[start] = cnt++;
    	
    	while(!q.isEmpty()) {
    		int a = q.poll();
    		
    		for(int i = 0; i < graph.get(a).size(); i++) {
    			int nextV = graph.get(a).get(i);
    			
    			if(visited[nextV] == 0) {
    				q.offer(nextV);
        			visited[nextV] = cnt++;
    			}  			
    		}
    	}
    }
}
