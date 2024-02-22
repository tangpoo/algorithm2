class Solution {
            public String solution(String s) {
                String answer = "";
                String[] arr = s.split("");

                int cnt = 0;
                for (int i = 0; i < arr.length; i++) {
                    String str = arr[i];
                    if(str.equals(" ")){
                        cnt = 0;
                    }
                    else{
                        cnt += 1;
                    }

                    answer += cnt % 2 == 0 ? str.toLowerCase() : str.toUpperCase();
                }

                return answer;
            }
        }