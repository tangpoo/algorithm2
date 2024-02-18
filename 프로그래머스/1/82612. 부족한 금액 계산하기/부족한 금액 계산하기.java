class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long totalPrice = 0;
        
        for(int i = 1; i <= count; i++){
            totalPrice += i * price; 
        }
        
        if(totalPrice <= money){
            return 0;
        }
        else{
            return totalPrice - money; 
        }
    }
}