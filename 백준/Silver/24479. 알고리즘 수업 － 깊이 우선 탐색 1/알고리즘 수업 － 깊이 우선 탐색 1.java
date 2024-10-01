import java.io.*;
import java.util.*;

class Main{
    
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] check;
    static int count;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        check = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for(int i = 0; i < graph.size(); i++){
            Collections.sort(graph.get(i));
        }
        
        count = 1;
        
        dfs(r);
        
        for(int i = 1; i < check.length; i++){
            sb.append(check[i]).append('\n');
        }
        System.out.println(sb);
    }
    
    static void dfs(int vertex){
        check[vertex] = count;
        
        for(int i = 0; i < graph.get(vertex).size(); i++){
            int newVertex = graph.get(vertex).get(i);
            
            if(check[newVertex] == 0){
                count++;
                dfs(newVertex);
            }
        }
    }
}