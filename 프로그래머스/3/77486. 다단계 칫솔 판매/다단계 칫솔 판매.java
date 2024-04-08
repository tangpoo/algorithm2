import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            map.put(enroll[i], 0);
        }
        
        HashMap<String, String> parent = new HashMap();
        for(int i = 0; i < referral.length; i++){
            parent.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i < seller.length; i++){
            String key = seller[i];
            int nowPay = amount[i] * 100;
            while(!key.equals("-")){
                int pay = nowPay / 10;
                int sale = nowPay - pay;
                map.put(key, map.get(key) + sale);
                
                nowPay = pay;
                if(nowPay < 1) break;
                key = parent.get(key);
            }
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = map.get(enroll[i]);
        }
        
        return answer;
    }
}