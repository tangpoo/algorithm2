import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = Long.toString(n);
        int[] arr = new int[str.length()];
        
        for(int i = 0; i < str.length(); i++){
            arr[i] = str.charAt(i) - '0';
        }
        
        
        Integer[] tmp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        
            
        for(int i = 0; i < tmp.length; i++){
            answer = answer * 10 + tmp[i];
        }
        
        return answer;
    }
}