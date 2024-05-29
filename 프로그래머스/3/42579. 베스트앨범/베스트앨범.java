import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]); 
        }
        
        ArrayList<String> list = new ArrayList<>();
        while(map.size() != 0){
            int max = -1;
            String k = "";
            for(String key : map.keySet()){
                if(map.get(key) > max){
                    max = map.get(key);
                    k = key;
                }
            }
            map.remove(k);
            list.add(k);
        }
        
        ArrayList<Music> result = new ArrayList<>();
        for(String key : list){
            ArrayList<Music> temp = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(key)){
                    temp.add(new Music(genres[i], plays[i], i));
                }
            }
            Collections.sort(temp, (o1, o2) -> o2.play - o1.play);
            
            result.add(temp.get(0));            
            if(temp.size() > 1){
                result.add(temp.get(1));
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        
        return answer;
    }
}
class Music{
    String key;
    int play;
    int idx;
    public Music(String key, int play, int idx){
        this.key = key;
        this.play = play;
        this.idx = idx;
    }
}