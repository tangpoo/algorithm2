import java.util.*;
class Solution {
        
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(s.length() > 1){
            int cnt = 0;
            
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0') answer[1]++;
                else cnt++;
            }
            
            s = Integer.toBinaryString(cnt);
            answer[0]++;
        }
        
        return answer;
    }
}

//문자열 x에서 0을 제거
//남은 문자열 x의 length를 2진법으로 변환 문자열 s로 칭함
//문자열 s가 1이 될 때까지 반복
//반복된 횟수와 모든 과정에서 제거된 0의 개수를 각각 배열에 담아 return