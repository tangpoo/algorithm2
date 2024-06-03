class Solution {
    
    static int n, result = Integer.MAX_VALUE;
    static int[] rot;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1, 0};
    static int[] dy = {-1, 1, 0, 0, 0};
    
    public int solution(int[][] clockHands) {
        n = clockHands.length;
        rot = new int[n];
        map = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = 4 - clockHands[i][j] == 4 ? 0 : 4 - clockHands[i][j];
            }
        }
        
        dfs(0);
        return result;
    }
    
    static void dfs(int idx){
        if(idx == n){
            int[] cur = rot.clone();
            int[][] tmp = new int[n][n];

            for(int i = 0; i < n; i++){
                tmp[i] = map[i].clone();
            }
            
            int tmpRes = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    tmpRes += cur[j];
                    
                    for(int d = 0; d < 5; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        
                        tmp[nx][ny] = tmp[nx][ny] - cur[j] >= 0 ? tmp[nx][ny] - cur[j] : tmp[nx][ny] - cur[j] + 4;
                    }
                }
                
                for(int j = 0; j < n; j++){
                    cur[j] = tmp[i][j];
                }
            }
            
            boolean flag = true;
            for(int i = 0; i < n; i++){
                if(cur[i] != 0){
                    flag = false;
                    break;
                }
            }
            
            if(flag) result = Math.min(result, tmpRes);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            rot[idx] = i;
            dfs(idx + 1);
        }
    }
}