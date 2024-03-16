import java.util.*;
class Solution {
    
    static ArrayList<ArrayList<Integer>> list;
    static int[] digit;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        list = new ArrayList<>();
        
        for(int i = 0; i < n + 1; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        digit = new int[n + 1];
        Arrays.fill(digit, Integer.MAX_VALUE);
        dijkstra(destination, n + 1);
        
        for(int i = 0; i < sources.length; i++){            
            
            answer[i] = (digit[sources[i]] == Integer.MAX_VALUE) ? -1 : digit[sources[i]];
        }
        
        return answer;
    }
    
    static int[] dijkstra(int start, int len){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(start);
        digit[start] = 0;
        
        while(!pq.isEmpty()){
            int now = pq.poll();
            
            for(int next : list.get(now)){
                if(digit[next] > digit[now] + 1){
                    digit[next] = digit[now] + 1;
                    pq.add(next);
                    
                }
            }
        }
        return digit;
    }
}