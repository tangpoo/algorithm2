import java.util.*;
class Solution {
    
    static ArrayList<String> list;
    static boolean[] visit;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visit = new boolean[tickets.length + 1];
        int cnt = 0;
        list = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, cnt);
        
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }
    
    static void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            list.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(start.equals(tickets[i][0]) && !visit[i]){
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visit[i] = false;
            }
        }
    }
}