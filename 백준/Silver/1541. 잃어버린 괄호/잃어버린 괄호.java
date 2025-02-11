import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sub = br.readLine().split("-");

        int result = sum(sub[0]);
        for (int i = 1; i < sub.length; i++) {  
            result -= sum(sub[i]);
        }

        System.out.println(result);
    }

    private static int sum(String s) {
        String[] add = s.split("\\+");
        int sum = 0;
        for (String num : add) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}

