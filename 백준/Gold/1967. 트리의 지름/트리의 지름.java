import java.io.*;
import java.util.*;

class Main{
    
    static int max = 0, idx = 0;
    static boolean[] visit;
    static ArrayList<Node>[] tree;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n - 1; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            tree[a].add(new Node(b, cost));
            tree[b].add(new Node(a, cost));
        }
        
        visit = new boolean[n + 1];
        visit[1] = true;
        dfs(1, 0);
        
        visit = new boolean[n + 1];
        visit[idx] = true;
        dfs(idx, 0);
        
        System.out.println(max);
    }
    
    static void dfs(int x, int depth){
        if(depth > max){
            max = depth;
            idx = x;
        }
        
        for(Node now : tree[x]){
            if(!visit[now.b]){
                visit[now.b] = true;
                dfs(now.b, now.cost + depth);
            }
        }
    }
    static class Node{
    	int b, cost;
    	
    	public Node(int b, int cost) {
    		this.b = b;
    		this.cost = cost;
    	}
    }
}