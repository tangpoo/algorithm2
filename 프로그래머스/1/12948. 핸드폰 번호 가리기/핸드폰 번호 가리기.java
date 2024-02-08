class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        int len = phone_number.length() - 4;
        phone_number = phone_number.substring(phone_number.length() - 4);
        
        for(int i = 0; i < len; i++){
            answer += "*";
        }
        answer += phone_number;
        
        return answer;
    }
}