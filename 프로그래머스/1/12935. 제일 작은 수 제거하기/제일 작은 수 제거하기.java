import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1){
            arr[0] = -1;
            return arr;
        }
        
        int[] answer = new int[arr.length-1];
        
        
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
                
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(min == arr[i]){
                continue;
            }
            else{
                answer[idx++] = arr[i];
            }
        }
        
        return answer;
    }
}