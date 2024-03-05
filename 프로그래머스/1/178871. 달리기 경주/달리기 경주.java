import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> mapByPlayer = new HashMap<>();
        HashMap<Integer, String> mapByRank = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            mapByPlayer.put(players[i], i);
            mapByRank.put(i, players[i]);
        }
        
        for(int i = 0; i < callings.length; i++){
            int currentRank = mapByPlayer.get(callings[i]);
            String player = mapByRank.get(currentRank);
            
            String frontPlayer = mapByRank.get(currentRank-1);
            
            mapByPlayer.put(player, currentRank-1);
            mapByPlayer.put(frontPlayer, currentRank);
            
            mapByRank.put(currentRank-1, player);
            mapByRank.put(currentRank, frontPlayer);
        }
        
        for(int i = 0; i < players.length; i++){
            answer[i] = mapByRank.get(i);
        }
        return answer;
    }
}