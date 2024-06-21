class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int point = key.length - 1;
        
        for(int x = 0; x < point + lock.length; x++){
            for(int y = 0; y < point + lock.length; y++){
                for(int r = 0; r < 4; r++){
                    int[][] newLock = new int[lock.length + key.length * 2][lock.length + key.length * 2];
                    
                    for(int i = 0; i < lock.length; i++){
                        for(int j = 0; j < lock.length; j++){
                            newLock[i + point][j + point] = lock[i][j];
                        }
                    }
                    match(newLock, key, r, x, y);
                    if(check(newLock, point, lock.length)) return true;
                }
            }
        }
        return false;
    }
    
    public void match(int[][] newLock, int[][] key, int r, int x, int y){
        int len = key.length;
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(r == 0){
                    newLock[i + x][j + y] += key[i][j];
                }
                if(r == 1){
                    newLock[i + x][j + y] += key[j][len - i - 1];
                }
                if(r == 2){
                    newLock[i + x][j + y] += key[len - i - 1][len - j - 1];
                }
                if(r == 3){
                    newLock[i + x][j + y] += key[len - j - 1][i];
                }
            }
        }
    }
    public boolean check(int[][] newLock, int point, int len){
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(newLock[i + point][j + point] != 1) return false;
            }
        }
        return true;
    }
}