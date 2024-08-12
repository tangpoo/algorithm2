import java.io.*;
import java.util.*;

class Main{
    
    static int N;
    static int[] indegree;
    static boolean[][] edges;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            N = Integer.parseInt(br.readLine());
            indegree = new int[N+1];
            edges = new boolean[N+1][N+1];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int num = Integer.parseInt(st.nextToken());
                indegree[num] = i;
                
                for(int j = 1; j <= N; j++){
                    if(j != num && !edges[j][num]){
                        edges[num][j] = true;
                    }
                }
            }
            
            int M = Integer.parseInt(br.readLine());            
            
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                swap(a, b);
            }            
            System.out.println(topologicalSort());
        }
    }
    
    static String topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= N; i++){
                    if(indegree[i] == 0){
                        q.add(i);
                    }
            }
          
            for(int i = 1; i <= N; i++){
                if(q.isEmpty()){
                    return "IMPOSSIBLE";                   
                }
                if(q.size() > 1){
                    return "?";
                }
                int node = q.poll();
                sb.append(node + " ");
                
                for(int j = 1; j <= N; j++){
                    if(edges[node][j]){
                        edges[node][j] = false;
                        if(--indegree[j] == 0){
                            q.add(j);
                        }
                    }
                }
            }
        return sb.toString();
    }
    
    static void swap(int a, int b){
        if(edges[a][b]){
            edges[a][b] = false;
            edges[b][a] = true;
            indegree[a]++;
            indegree[b]--;
        }
        else{
            edges[a][b] = true;
            edges[b][a] = false;
            indegree[b]++;
            indegree[a]--;
        }
    }
}