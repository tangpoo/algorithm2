import java.io.*;
import java.util.*;

class Main{
    
    static int[] indegree;
    static int N, M;
    static ArrayList<List<Integer>> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        indegree = new int[N+1];
        
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.get(a).add(b);
            indegree[b]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                pq.add(i);
            }
        }
        
        while(!pq.isEmpty()){
            int now = pq.poll();
            System.out.print(now + " ");
            
            for(int i : list.get(now)){
                indegree[i]--;
                
                if(indegree[i] == 0){
                    pq.add(i);
                }
            }
        }
    }
}
