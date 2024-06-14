class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int rowLen = triangle.length;
        int[][] dp = new int[rowLen][rowLen];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < rowLen; i++){
            for(int j = 0; j < triangle[i].length; j++){
                if(j <= triangle[i].length - 1){
                    dp[i][j] = Math.max(dp[i-1][j] + triangle[i][j], dp[i][j]);
                }
                
                if(j >= 1){
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i][j]);
                }
            }
        }
        
        for(int i = 0; i < rowLen; i++){
            answer = Math.max(answer, dp[rowLen-1][i]);
        }
        return answer;
    }
}