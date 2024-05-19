import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] student = new int[N][5];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++){
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int answer = 0;
        for(int i = 0; i < N; i++){
            Set<Integer> sameClass = new HashSet<>();
            for(int j = 0; j < N; j++){
                if(i == j){
                    continue;
                }

                for(int k = 0; k < 5; k++){
                    if(student[i][k] == student[j][k]){
                        sameClass.add(j);
                    }
                }
            }

            if(max < sameClass.size()){
                max = sameClass.size();
                answer = i;
            }
        }

        System.out.println(answer + 1);
    }
}