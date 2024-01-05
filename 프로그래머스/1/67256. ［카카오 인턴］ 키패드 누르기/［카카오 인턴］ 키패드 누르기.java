import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        List<Integer> left_list = new ArrayList<>(Arrays.asList(1, 4, 7));
        List<Integer> right_list = new ArrayList<>(Arrays.asList(3, 6, 9));
        
        
        int now_left = 10;
        int now_right = 12;
        
        for(int i = 0; i < numbers.length; i++){
            int num = numbers[i];
            
            if(left_list.contains(num)){
                answer += "L";
                now_left = num;
            }
            else if(right_list.contains(num)){
                answer += "R";
                now_right = num;
            }
            else{
                if(num == 0){
                num = 11;
                }
                int l_diff = Math.abs(num - now_left)/3 + Math.abs(num - now_left)%3;
                int r_diff = Math.abs(num - now_right)/3 + Math.abs(num - now_right)%3;
                                                  
                if(l_diff < r_diff){
                    answer += "L";
                    now_left = num;
                }
                else if (l_diff > r_diff){
                    answer += "R";
                    now_right = num;
                }
                else{
                    if(hand.equals("left")){
                    answer += "L";
                    now_left = num;
                }
                    else{
                        answer += "R";
                        now_right = num;
                    }
                }
            }
        }
        
        return answer;
    }
}