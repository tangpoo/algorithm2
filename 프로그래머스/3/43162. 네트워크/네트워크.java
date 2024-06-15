import java.util.*;
class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[computers.length];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[i].length; j++){
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                answer++;
            }
        }
        return answer;
    }
    
    static int find(int a){
        if(parent[a] == a) return a;
        
        return parent[a] = find(parent[a]);
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a != b){
            parent[b] = a;
        }
    }
}