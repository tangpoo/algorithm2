import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int total = 0;
        int end = 0;
        int idx = 0;
        int cnt = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while(cnt < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= end){
                pq.add(jobs[idx++]);
            }
            
            if(pq.isEmpty()){
                end = jobs[idx][0];
            }
            else{
                int[] now = pq.poll();
                total += now[1] + end - now[0];
                end += now[1];
                cnt++;
            }
        }
        return total / jobs.length;
    }
}