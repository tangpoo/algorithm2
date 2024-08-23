import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }
        
        boolean[] visited = new boolean[n];
        int[] parentNode = new int[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int v = q.poll();
            
            for(int node : tree.get(v)){
                if(!visited[node]){
                    visited[node] = true;
                    q.add(node);
                    parentNode[node] = v;
                }
            }
        }
        
        for(int i = 1; i < n; i++){
            System.out.println(parentNode[i] + 1);
        }
    }
}