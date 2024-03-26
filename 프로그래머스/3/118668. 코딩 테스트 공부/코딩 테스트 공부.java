class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = alp;
        int maxCop = cop;
        
        for(int i = 0; i < problems.length; i++){
            if(maxAlp < problems[i][0]) maxAlp = problems[i][0];
            if(maxCop < problems[i][1]) maxCop = problems[i][1];
        }
        
        if(maxAlp == alp && maxCop == cop) return 0;
        
        int[][] dp = new int[maxAlp + 2][maxCop + 2];
        for(int i = alp; i <= maxAlp; i++){
            for(int j = cop; j <= maxCop; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[alp][cop] = 0;
        for(int i = alp; i <= maxAlp; i++){
            for(int j = cop; j <= maxCop; j++){
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                
                for(int k = 0; k < problems.length; k++){
                    if(i >= problems[k][0] && j >= problems[k][1]){
                        if(i + problems[k][2] <= maxAlp && j + problems[k][3] <= maxCop){
                            dp[i + problems[k][2]][j + problems[k][3]] = Math.min(dp[i + problems[k][2]][j + problems[k][3]], dp[i][j] + problems[k][4]);
                        }
                        else if(i + problems[k][2] > maxAlp && j + problems[k][3] > maxCop){
                            dp[maxAlp][maxCop] = Math.min(dp[maxAlp][maxCop], dp[i][j] + problems[k][4]);
                        }
                        else if(i + problems[k][2] > maxAlp){
                            dp[maxAlp][j + problems[k][3]] = Math.min(dp[maxAlp][j + problems[k][3]], dp[i][j] + problems[k][4]);
                        }
                        else{
                            dp[i + problems[k][2]][maxCop] = Math.min(dp[i + problems[k][2]][maxCop], dp[i][j] + problems[k][4]);
                        }
                    }
                }
            }
        }
        
        return dp[maxAlp][maxCop];
    }
}