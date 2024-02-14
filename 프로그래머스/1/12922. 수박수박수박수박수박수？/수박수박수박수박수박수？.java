class Solution {
    public String solution(int n) {
        String answer = "";
        boolean flag = false;
        
        while(n --> 0){
                if(!flag){
                answer += "수";
                flag = true;
            }
            else{
                answer += "박";
                flag = false;
            }
        }
        
        return answer;
    }
}