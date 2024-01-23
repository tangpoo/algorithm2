class Solution {
    public int solution(String s) {
        int answer = 0;
        
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '-'){
                flag = true;
                continue;
            }
            if(s.charAt(i) == '+'){
                continue;
            }
            
            answer = s.charAt(i) - '0' + answer * 10;
        }
        
        if(flag){
            answer *= -1;
        }
        
        return answer;
    }
}