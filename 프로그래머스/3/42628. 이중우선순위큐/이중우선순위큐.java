import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String str : operations){
            
            String order = str.substring(0, 2);
            int num = Integer.parseInt(str.substring(2));
            
            if(pq1.size() < 1 && order.equals("D "))
                continue;
            if(order.equals("I ")){
                pq1.add(num);
                pq2.add(num);
            }
            else if(num < 0){
                int min = pq1.poll();
                pq2.remove(min);
            }
            else{
                int max = pq2.poll();
                pq1.remove(max);
            }
        }
        if(pq1.size() == 0 && pq2.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = pq2.poll();
            answer[1] = pq1.poll();
        }
        
        return answer;
    }
}