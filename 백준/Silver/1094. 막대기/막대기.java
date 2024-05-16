import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int stick = 64;
        int count = 0;

        while(x > 0){
            if(stick > x){
                stick /= 2;
            } else {
                x -= stick;
                count++;
            }
        }

        System.out.println(count);
    }
}