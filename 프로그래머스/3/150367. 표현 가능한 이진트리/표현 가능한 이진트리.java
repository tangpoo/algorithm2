class Solution {
    
    static int possible;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < answer.length; i++){
            String binaryNum = Long.toBinaryString(numbers[i]);
            int fullTreeLen = 0;
            int h = 1;
            
            while(fullTreeLen < binaryNum.length()){
                fullTreeLen = (int) Math.pow(2, h++) - 1;
            }
            
            boolean[] isOne = new boolean[fullTreeLen];
            
            int notDummyIdx = isOne.length - binaryNum.length();
            for(int j = 0; j < binaryNum.length(); j++){
                isOne[notDummyIdx++] = binaryNum.charAt(j) == '1';
            }
            
            possible = 1;
            dfs(0, isOne.length - 1, false, isOne);
            answer[i] = possible;
        }
        return answer;
    }
    
    static void dfs(int start, int end, boolean isParentZero, boolean[] isOne){
        if(possible == 0) return;
        
        int mid = (start + end) / 2;
        
        if(isParentZero && isOne[mid]){
            possible = 0;
            return;
        }
        
        if(start != end){
            dfs(start, mid - 1, !isOne[mid], isOne);
            dfs(mid + 1, end, !isOne[mid], isOne);
        }
    }
}