import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : works){
            pq.add(i);
        }
        
        while(n != 0){
            n--;
            int temp = pq.poll();
            if(temp == 0) break;
            temp--;
            
            pq.add(temp);
        }
        
        long sum = 0;
        for(int i : pq){
            sum += i * i;
        }
        
        return sum;
    }
}