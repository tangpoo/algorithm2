class Solution {
public static String solution(String s, int n) {
    StringBuilder a = new StringBuilder();
    // 시저암호
    // char를 사용해야되는 문제로 보임
    String[] arr = s.split(" ", -1);
    // 문자열 하나하나를 char로 바꾼 뒤 1을 더해주고 다시 문자열로 바꾼다.
    for (String string : arr) {
        int[] result = new StringBuilder().append(string).chars().map(e -> {
            // 65 <= e <= 90, 97 <= e <= 122
            if(65 <= e && e <= 90){
                if(e + n > 90){
                    return e + n -26;
                }
            }
            else if(97 <= e && e <= 122){
                if(e + n > 122){
                    return e + n - 26;
                }
            }
            return e + n;
        }).toArray();
        for (int i : result) {
            a.append((char) i);
        }
        a.append(" ");
    }
    return a.substring(0, a.length() - 1);
}
}