import java.util.*;
class Solution {
    
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static long[] long_a;
    static long answer = 0;
    
    public long solution(int[] a, int[][] edges) {        
        list = new ArrayList[a.length];
        visit = new boolean[a.length];
        long_a = new long[a.length];
        long sum = 0;
        
        for(int i = 0; i < a.length; i++){
            sum += a[i];
            long_a[i] = a[i];
            list[i] = new ArrayList<>();
        }
        if(sum != 0) return -1;
        
        for(int[] i : edges){
            list[i[0]].add(i[1]);
            list[i[1]].add(i[0]);
        }
        dfs(0);
        
        return answer;
    }
    
    static long dfs(int v){
        visit[v] = true;
        for(int i = 0; i < list[v].size(); i++){
                int next = list[v].get(i);
                if(!visit[next]){
                    long_a[v] += dfs(next);
                }
            }
        answer += Math.abs(long_a[v]);
        
        return long_a[v];
    }
}