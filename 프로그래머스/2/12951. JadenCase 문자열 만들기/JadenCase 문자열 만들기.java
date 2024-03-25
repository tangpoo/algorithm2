import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        String[] str = s.split("");
        boolean flag = true;
        
        for(String ss : str){
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }
        
        return answer;
    }
}