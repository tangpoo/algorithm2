import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String table : timetable){
            int time = Integer.parseInt(table.substring(0, 2)) * 60 + Integer.parseInt(table.substring(3));
            
            pq.add(time);
        }
        
        int startTime = 9 * 60;
        int lastTime = 0;
        int total = 0;
        for(int i = 0; i < n; i++){
            total = 0;
            while(!pq.isEmpty()){
                int current_time = pq.peek();
                if(current_time <= startTime && total < m){
                    pq.poll();
                    total++;
                }
                else break;
                
                lastTime = current_time - 1;
            }
            startTime += t;
        }
        if(total < m) lastTime = startTime - t;
        
        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);
        return hour + ":" + minute;
    }
}