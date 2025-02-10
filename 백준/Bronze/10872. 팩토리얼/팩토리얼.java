import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 1;
        for(int i = n; i > 1; i--) {
            result = result * i;
        }

        System.out.println(result);
    }
}
