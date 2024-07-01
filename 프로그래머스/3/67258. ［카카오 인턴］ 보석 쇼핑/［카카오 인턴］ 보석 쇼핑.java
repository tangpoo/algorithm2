import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < gems.length; i++){
            set.add(gems[i]);
        }
        
        int start = 0, end = 0, min = 100001;
        while(true){                        
            if(set.size() == map.size()){
                if(min > end - start){
                    min = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0){
                    map.remove(gems[start]);
                }                
                
                start++;
            }
            else if(end == gems.length) break;
            
            else if(set.size() > map.size()){
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;                
            } 
            
            else{
                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0){
                    map.remove(gems[start]);
                }
                start++;
            }
        }
        return answer;
    }
}