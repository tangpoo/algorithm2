import java.util.*;

class Solution {
    
    static int n;
    static int[] enemy;
    
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int round = 0; round < enemy.length; round++){
            q.add(enemy[round]);
            
            if(q.size() > k)
                n -= q.poll();
            
            if(n < 0)
                return round;
            
        }
        return enemy.length;
    }    
}