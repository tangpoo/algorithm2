import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1];
        }

        System.out.println(sum[n]);
    }
}
