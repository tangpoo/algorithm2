class Solution {
    
    static int n, answer;
    static int[] weak, dist;
    static int[][] weak_cases;
    
    public int solution(int n, int[] weak, int[] dist) {
        weak_cases = new int[weak.length][weak.length];
        this.answer = dist.length + 1;
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        
        makeWeakCase();
        makeDistCase(new boolean[dist.length], new int[dist.length], 0);
        
        if(answer == dist.length + 1) return -1;
        
        return answer;
    }
    
    static void makeWeakCase(){
        int[] weakCase = weak.clone();
        weak_cases[0] = weakCase.clone();
        
        for(int i = 1; i < weak.length; i++){
            int temp = weakCase[0];
            
            for(int j = 1; j < weak.length; j++){
                weakCase[j - 1] = weakCase[j];
            }
            
            weakCase[weak.length - 1] = temp + n;
            weak_cases[i] = weakCase.clone();
        }
    }
    
    static void makeDistCase(boolean[] visit, int[] distCase, int idx){
        if(idx == dist.length){
            for(int[] weakCase : weak_cases){
                check(weakCase, distCase);
            }
        }
        
        for(int i = 0; i < dist.length; i++){
            if(!visit[i]){
                visit[i] = true;
                distCase[idx] = dist[i];
                makeDistCase(visit, distCase, idx + 1);
                distCase[idx] = 0;
                visit[i] = false;
            }
        }
    }
    
    static void check(int[] weakCase, int[] distCase){
        int cur = 0, next;
        int dist_idx = 0;
        
        while(cur < weakCase.length && dist_idx < distCase.length){
            next = cur + 1;
            
            while(next < weakCase.length && weakCase[cur] + distCase[dist_idx] >= weakCase[next])
                next++;
            
            cur = next;
            dist_idx++;
        }
        
        if(cur == weakCase.length && answer > dist_idx){
            answer = dist_idx;
        }
    }
}