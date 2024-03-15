import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(tangerine);
        int answer = 0;
        
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0)+1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        for(int i : keySet){
            k -= map.get(i);
            answer++;
            if(k <= 0){
                return answer;
            }
        }
        return answer;
    }
}