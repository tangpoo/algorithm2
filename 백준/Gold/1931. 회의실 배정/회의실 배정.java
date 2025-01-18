import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        
        
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(time, new Comparator<int[]>(){
            
            public int compare(int[] o1, int[] o2){
                
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                
                    return o1[1] - o2[1];

            }
        });
        
        int count = 0;
        int prev_time = 0;
        
        for(int i = 0; i < n; i++){
            if(prev_time <= time[i][0]){
                prev_time = time[i][1];
                count++;
            }
        }
        
        System.out.println(count);
    }
}