import java.util.*;
class Solution {
    
    static int[] visit;
    static ArrayList<Integer>[] list;
    static int depth = 0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visit = new int[n+1];
        list = new ArrayList[n+1];
        
        for(int i = 1; i < n+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        bfs(1, 1);
        
        for(int i = 1; i < n + 1; i++){
            if(visit[i] == depth){
                answer++;
            }
        }
            
        return answer;
    }
    
    static void bfs(int start, int cnt){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        q.add(cnt);
        visit[start] = cnt;        
        
        while(!q.isEmpty()){
            int now = q.poll();
            int n = q.poll();
            
            if(depth < n) depth = n;
            for(int next : list[now]){
                if(visit[next] != 0){
                    continue;
                }
                
                visit[next] = n + 1;
                q.add(next);
                q.add(n + 1);
            }
        }
    }
}