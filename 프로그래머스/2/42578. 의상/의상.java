import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] clothe : clothes){
            String type = clothe[1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        Iterator<Integer> iter = map.values().iterator();
        int answer = 1;
        
        while(iter.hasNext()){
            answer *= iter.next().intValue() + 1;
        }
        
        return answer - 1;
    }
}