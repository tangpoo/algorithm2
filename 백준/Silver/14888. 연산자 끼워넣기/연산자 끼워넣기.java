import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] arr;
    static int[] op;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        op = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(n, 1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int n, int depth, int result) {
        if (n == depth) {
            if (result < min) {
                min = result;
            }
            if (result > max) {
                max = result;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                int nextResult = calculate(result, arr[depth], i);
                op[i]--;
                dfs(n, depth + 1, nextResult);
                op[i]++;
            }
        }
    }

    private static int calculate(int a, int b, int operator) {
        if (operator == 0) {
            return a + b;
        }
        else if (operator == 1) {
            return a - b;
        }
        else if (operator == 2) {
            return a * b;
        }
        return a / b;
    }
}
