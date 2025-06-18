import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int set = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            int x = 0;

            if (input.length == 2) {
                x = Integer.parseInt(input[1]);
            }

            switch (cmd) {
                case "add":
                    set |= (1 << x);
                    break;
                case "remove":
                    set &= ~(1 << x);
                    break;
                case "check":
                    sb.append((set & (1 << x)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    set ^= (1 << x);
                    break;
                case "all":
                    set = (1 << 21) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}