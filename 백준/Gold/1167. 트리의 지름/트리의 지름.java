import java.io.*;
import java.util.*;

class Main{
    
    static class Node{
        int b, val;
        public Node(int b, int val){
            this.b = b;
            this.val = val;
        }
    }
    static ArrayList<Node>[] tree;
    static boolean[] visit;
    static int max = 0; 
    static int node;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            
            while(true){
                int b = Integer.parseInt(st.nextToken());
                if(b == -1) break;
                int val = Integer.parseInt(st.nextToken());
                
                tree[a].add(new Node(b, val));
                tree[b].add(new Node(a, val));
            }
        }
        
        visit = new boolean[n + 1];
        dfs(1, 0);
        
        visit = new boolean[n + 1];
        dfs(node, 0);
        
        System.out.println(max);
    }
    static void dfs(int x, int len){
        if(len > max){
            max = len;
            node = x;
        }
        visit[x] = true;
        
        for(int i = 0; i < tree[x].size(); i++){
            Node n = tree[x].get(i);
            
            if(!visit[n.b]){                
                dfs(n.b, len + n.val);
                visit[n.b] = true;
            }
        }
    }
}
