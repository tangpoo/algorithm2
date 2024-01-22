import java.util.*;
class Solution {
    public int[] solution(long n) {
        Stack stack = new Stack();
        
        String str = Long.toString(n);
        int[] num = new int[str.length()];
        
        for(int i = 0; i < str.length(); i++){
            stack.push((int)(str.charAt(i)) - '0');
        }
        
        for(int i = 0; i < str.length(); i++){
            num[i] = (int)stack.pop();
        }
        
        return num;
    }
}