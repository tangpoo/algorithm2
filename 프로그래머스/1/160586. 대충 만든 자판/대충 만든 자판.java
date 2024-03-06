import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < keymap.length; i++){
            String str = keymap[i];
            
            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                if(map.containsKey(ch)){
                    int idx = map.get(ch);
                    map.put(ch, Math.min(j + 1, idx));
                }
                else{
                    map.put(ch, j + 1);
                }
            }
        }
        
        int idx = 0;
        for(int i = 0; i < targets.length; i++){
            String str = targets[i];
            int cnt = 0;
            
            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                if(!map.containsKey(ch)){
                    cnt = -1;
                    break;
                }
                else{
                    cnt += map.get(ch);
                }
            }
            
            answer[idx++] = cnt;
        }
        
        return answer;
    }
}

