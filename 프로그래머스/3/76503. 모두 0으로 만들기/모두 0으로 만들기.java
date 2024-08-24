import java.util.*;
class Solution {
    
    static long[] copyA;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static long answer = 0;
    
    public long solution(int[] a, int[][] edges) {        
        copyA = new long[a.length];
        list = new ArrayList[a.length];
        visit = new boolean[a.length];
        int sum = 0;
        
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
            copyA[i] = a[i];
            list[i] = new ArrayList();
        }
        
        if(sum != 0) return -1;
        
        for(int i = 0; i < edges.length; i++) {
            list[edges[i][1]].add(edges[i][0]);
            list[edges[i][0]].add(edges[i][1]);
        }
        
        dfs(0);
        
        return answer;
        
    }
    
    static long dfs(int v) {
        visit[v] = true;
        
        for(int i = 0; i < list[v].size(); i++) {
            int next = list[v].get(i);
            
            if(!visit[next]) {
                copyA[v] += dfs(next);
            }
        }
        answer += Math.abs(copyA[v]);
        
        return copyA[v];
    }
}