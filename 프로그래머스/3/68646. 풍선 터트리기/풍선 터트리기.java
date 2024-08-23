class Solution {
    public int solution(int[] a) {
        
        if(a.length == 1){
            return 1;
        }
        
        int answer = 2;
        
        int[] leftMin = new int[a.length];
        int left = a[0];
        int[] rightMin = new int[a.length];
        int right = a[a.length - 1];
        
        for(int i = 1; i < a.length - 1; i++) {
            if(left > a[i]) {
                left = a[i];
            }
            
            leftMin[i] = left;
        }
        
        for(int i = a.length - 2; i > 0; i--) {
            if(right > a[i]) {
                right = a[i];
            }
            
            rightMin[i] = right;
        }
        
        for(int i = 1; i < a.length - 1; i++) {
            if(leftMin[i] < a[i] && rightMin[i] < a[i]) {
                continue;
            }
            
            answer++;
        }
        
        return answer;
    }
}