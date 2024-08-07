class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long) (10e9 * 2 * 10e5 * 2);
        
        int cityLen = g.length;
        long start = 0;
        long end = (long) (10e9 * 2 * 10e5 * 2);
        
        while(start <= end){
            long mid = (start + end) / 2;
            int gold = 0;
            int silver = 0;
            int total = 0;
            
            for(int i = 0; i < cityLen; i++){
                int nowGold = g[i];
                int nowSilver = s[i];
                int weight = w[i];
                long time = t[i];
                
                long moveCount = mid / (time * 2);
                if(mid % (time * 2) >= time) moveCount++;
                
                gold += Math.min(nowGold, weight * moveCount);
                silver += Math.min(nowSilver, weight * moveCount);
                total += Math.min(nowGold + nowSilver, weight * moveCount);
            }
            
            if(a <= gold && b <= silver && a + b <= total){
                answer = Math.min(answer, mid);
                end = mid - 1;                
            }
            else{
                start = mid + 1;
            }
        }
        
        return answer;
    }
}