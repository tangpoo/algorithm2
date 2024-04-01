import java.util.*;
class Solution {
    
    static ArrayList<Node>[] list;
    
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] mountain : paths){
            int a = mountain[0];
            int b = mountain[1];
            int c = mountain[2];
            
            if(isStart(a, gates) || isEnd(b, summits)){
                list[a].add(new Node(b, c));
            }
            else if(isEnd(b, gates) || isStart(a, summits)){
                list[b].add(new Node(a, c));
            }
            else{
                list[a].add(new Node(b, c));
                list[b].add(new Node(a, c));
            }
        }
                        
        return dijkstra(n, gates, summits);
    }
    static int[] dijkstra(int n, int[] gates, int[] summits){
        Queue<Node> q = new LinkedList<>();
        int[] dist = new int[n+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int gate : gates){
            q.add(new Node(gate, 0));
            dist[gate] = 0;
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            if(now.c > dist[now.b]) continue;
            
            for(Node next : list[now.b]){
                int dis = Math.max(dist[now.b], next.c);
                
                if(dist[next.b] > dis){
                    dist[next.b] = dis;
                    q.add(new Node(next.b, dis));
                }
            }
        }
        
        
        int end = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        Arrays.sort(summits);
        
        for(int summit : summits){
            if(dist[summit] < min){
                min = dist[summit];
                end = summit;
            }
        }
        
        return new int[]{end, min};
    }
    
    static boolean isStart(int n, int[] gates){
        for(int gate : gates){
            if(n == gate) return true;
        }
        return false;
    }
    static boolean isEnd(int n, int[] summits){
        for(int summit : summits){
            if(n == summit) return true;
        }
        return false;
    }
    
    static class Node{
        int b, c;
        
        public Node(int b, int c){
            this.b = b;
            this.c = c;
        }
    }
}