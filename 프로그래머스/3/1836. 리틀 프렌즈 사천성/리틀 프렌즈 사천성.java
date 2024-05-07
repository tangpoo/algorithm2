import java.util.*;
class Solution {
    
    char[][] board;
    int m, n;
    LinkedList<Character> list = new LinkedList<>();
    HashMap<Character, int[][]> map = new HashMap<>();
    
    
    public String solution(int m, int n, String[] board) {
        String answer = "";
        this.board = new char[m][n];
        this.m = m;
        this.n = n;
                
        for(int i = 0; i < m; i++){            
            for(int j = 0; j < n; j++){
                char c = board[i].charAt(j);
                this.board[i][j] = c;
                
                if(c != '.' && c != '*'){
                    if(!list.contains(c)){
                        list.add(c);
                        map.put(c, new int[2][2]);
                        map.get(c)[0][0] = i;
                        map.get(c)[0][1] = j;
                    }
                    else{
                        map.get(c)[1][0] = i;
                        map.get(c)[1][1] = j;
                    }
                }
            }            
        }
        
        Collections.sort(list);
        
        
        int idx = 0;
        while(list.size() != 0){
            if(canDelete(list.get(idx))){
                char popped = list.remove(idx);
                answer += popped;
                deleteChar(popped);
                idx = 0;
            } 
            else{
                idx++;
                if(idx == list.size()){
                    return "IMPOSSIBLE";
                }       
            }
        }
        
        return answer;
    }
    
    void deleteChar(char c){
        board[map.get(c)[0][0]][map.get(c)[0][1]] = '.';
        board[map.get(c)[1][0]][map.get(c)[1][1]] = '.';
    }
    
    boolean canDelete(char c){
        int r1 = map.get(c)[0][0];
        int c1 = map.get(c)[0][1];
        int r2 = map.get(c)[1][0];
        int c2 = map.get(c)[1][1];
        
        if(c1 < c2){
            if(colCheck(c1, c2, r1, c) && rowCheck(r1, r2, c2, c)){
                return true;
            }
            if(rowCheck(r1, r2, c1, c) && colCheck(c1, c2, r2, c)){
                return true;
            }
        }
        else{
            if(rowCheck(r1, r2, c2, c) && colCheck(c2, c1, r1, c)){
                return true;
            }
            if(colCheck(c2, c1, r2, c) && rowCheck(r1, r2, c1, c)){
                return true;
            }
        }
        
        return false;
    }
    
    boolean rowCheck(int r1, int r2, int col, char c){
        for(int i = r1; i <= r2; i++){
            if(board[i][col] != '.' && board[i][col] != c)
                return false;
        }
        return true;
    }
    boolean colCheck(int c1, int c2, int row, char c){
        for(int i = c1; i <= c2; i++){
            if(board[row][i] != '.' && board[row][i] != c)
                return false;
        }
        return true;
    }
}