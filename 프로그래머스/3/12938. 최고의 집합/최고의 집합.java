import java.util.*;
class Solution {
    
    ArrayList<Integer> list;
    
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[]{-1};
        }
        int[] answer = new int[n];
        int mod = s % n;
        int mul = s / n;
        
        for(int i = 0; i < n; i++){
            answer[i] = mul;
        }
        for(int i = 0; i < mod; i++){
            answer[i]++;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}