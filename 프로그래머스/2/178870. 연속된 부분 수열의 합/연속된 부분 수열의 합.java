import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {       
    	int left = 0, right = 0;
        int sum = 0;
        int start = 0, end = 0;
        int N = sequence.length;
        
        for(right = 0; right < sequence.length; right++){
            sum += sequence[right];
            
            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            if(sum == k){
                if(N > right - left){
                    N = right - left;
                    start = left;
                    end = right;
                }
                else if(N == right - left){
                    start = Math.min(left, start);
                    end = Math.min(right, end);
                }
            }
        }
    	
    	return new int[] {start, end};
    }
}