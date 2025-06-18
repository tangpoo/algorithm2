import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long sum = 0;
        long count = 0;

        while (sum + count <= n) {
            sum += count;
            count++;
        }

        System.out.println(count - 1);
    }
}