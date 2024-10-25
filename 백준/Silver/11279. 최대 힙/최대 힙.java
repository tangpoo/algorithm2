//null 일 경우에만 0을 출력하도록 만들고, 나머지는 reverseOrder 순으로 poll 출력.
import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        while(n --> 0){
            int a = Integer.parseInt(br.readLine());
            
            if(a == 0){
                if(pq.isEmpty()){
                    sb.append(0).append('\n');
                }
                else{
                    sb.append(pq.poll()).append('\n');
                }
            }
            else{
                pq.add(a);
            }
        }
        
        System.out.println(sb);
    }
}