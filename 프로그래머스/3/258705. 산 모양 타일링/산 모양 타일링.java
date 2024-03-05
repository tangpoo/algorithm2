class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int[][] dp = new int[n + 1][2];
        dp[0][1] = 1;
        
        for(int i = 0; i < n; i++){
            int top = tops[i];
            int k = i + 1;
            
            dp[k][0] = (dp[i][0] + dp[i][1]) % 10007;
            if(top == 0){
                dp[k][1] = (dp[i][0] + dp[i][1] * 2) % 10007;
            }
            else{
                dp[k][1] = (dp[i][0] * 2 + dp[i][1] * 3) % 10007;
            }
        }
        
        return (dp[n][0] + dp[n][1]) % 10007;
    }
}

// 가운데 삼각형을 기준으로 마름모를 만드는 경우의 수(+1)는 top인 경우 + 4, 아닌 경우 + 3
// 가장 왼쪽 아래 삼각형은 다음 경우에서 빼야함
// 즉 다음의 수가 영향을 받는 것은 top의 유무와 이전에 오른쪽 아래의 삼각형을 사용했는가의 여부
