import java.io.*;
import java.util.*;

class Main{
    
    static int[][] graph;
    static boolean[] check;
    static int n;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        check = new boolean[1001];
        graph = new int[1001][1001];
        
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            graph[j][k] = graph[k][j] = 1;
        }
        
        dfs(v);
               
        check = new boolean[1001];
        System.out.println();
        
        bfs(v);
        
    }
    
    static void dfs(int start){
        check[start] = true;
        
        System.out.print(start + " ");
        
        for(int i = 1; i <= n; i++){
            
            if(check[i] == false && graph[start][i] == 1){
                dfs(i);
            }
        }
    }
    
    static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	
    	q.offer(start);
    	check[start] = true;
    	
    	System.out.print(start + " ");
    	
    	while(!q.isEmpty()) {
    		int a = q.poll();
    		
    		for(int i = 1; i <= n; i++) {
    			
    			if(check[i] == false && graph[a][i] == 1) {
    				q.offer(i);
    				check[i] = true;
    				System.out.print(i + " ");
    			}
    		}
    	}
    }
}