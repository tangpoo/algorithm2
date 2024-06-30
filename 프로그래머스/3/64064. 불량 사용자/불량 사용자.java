import java.util.*;
class Solution {
    
    static HashSet<String> set;
    static boolean[] visit;
    
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        visit = new boolean[user_id.length];
        
        for(int i = 0; i < banned_id.length; i++){
            banned_id[i] = banned_id[i].replace('*', '.');
        }
        
        dfs(user_id, banned_id, 0, "");
        
        return set.size();
    }
    
    static void dfs(String[] user_id, String[] banned_id, int depth, String str){
        if(depth == banned_id.length){
            String[] comb = str.split(" ");
            Arrays.sort(comb);
            String result = "";
            
            for(String res : comb){
                result += res;
            }
            
            set.add(result);
            return;
        }
        
        for(int i = 0; i < user_id.length; i++){
            if(user_id[i].matches(banned_id[depth]) && !visit[i]){
                visit[i] = true;
                dfs(user_id, banned_id, depth + 1, str + " " + user_id[i]);
                visit[i] = false;
            }
        }
    }
}