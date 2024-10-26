import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            
            if(a == 0){
                if(pq.peek() == null){
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