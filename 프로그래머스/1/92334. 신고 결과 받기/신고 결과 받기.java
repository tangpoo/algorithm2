import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> declaration = new HashMap<>();
        Map<String, HashSet<String>> arrest = new HashMap<>();
        
        for(int i = 0; i < report.length; i++){
            String[] reported = report[i].split(" ");
            
            boolean flag = true;
            
            if(arrest.containsKey(reported[0])){
                if(arrest.get(reported[0]).contains(reported[1])){
                    flag = false;
                }
                else{
                    arrest.get(reported[0]).add(reported[1]);
                }
            } else {
                arrest.put(reported[0], new HashSet<String>(){{
                    add(reported[1]);
                }});
            }
            
            
          if (!flag) {
              continue;
          } else if (declaration.containsKey(reported[1])){
              declaration.put(reported[1], declaration.get(reported[1])+1);
          } else {
              declaration.put(reported[1], 1);
          }
        }
        
       for (String reported : declaration.keySet()){
          int reportedCount = declaration.get(reported);
          if(reportedCount >= k){
              for(int i = 0; i < id_list.length; i++){
                  if(arrest.get(id_list[i]) == null){
                      answer[i] = 0;
                  } else if(arrest.get(id_list[i]).contains(reported)){
                      answer[i]++;
                  }
              }
          }
      }
        
        return answer;
    }
}