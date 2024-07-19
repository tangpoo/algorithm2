import java.util.*;
class Solution {
    
    static int max = (100000 * 200) + 1;
    static ArrayList<ArrayList<Edge>> list;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];
            
            list.get(start).add(new Edge(end, cost));
            list.get(end).add(new Edge(start, cost));
        }
        
        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] start = new int[n+1];
        
        Arrays.fill(startA, max);
        Arrays.fill(startB, max);
        Arrays.fill(start, max);
        
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);
        
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        }
        return answer;
    }
    
    static int[] dijkstra(int start, int[] costs){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        costs[start] = 0;
        
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            
            if(now.cost > costs[now.index]) continue;

            for(Edge next : list.get(now.index)){
                int cost = next.cost + costs[now.index];
                
                if(cost < costs[next.index]){
                    costs[next.index] = cost;
                    pq.add(new Edge(next.index, cost));
                }
            }
        }
        return costs;
    }
}
class Edge implements Comparable<Edge>{
    int index, cost;
    public Edge(int index, int cost){
        this.index = index;
        this.cost = cost;
    }
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}