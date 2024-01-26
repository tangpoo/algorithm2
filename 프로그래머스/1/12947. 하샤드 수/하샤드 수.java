class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        
        int tmp = x;
        int num = 0;
        while(tmp >= 10){
            num += tmp % 10;
            tmp /= 10;
        }
        num += tmp;
        
        if(x % num == 0){
            answer = true;
        }
        
        return answer;
    }
}