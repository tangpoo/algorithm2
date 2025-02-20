import java.io.*;
import java.util.PriorityQueue;
import java.util.Collections;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++){
            if(maxPQ.size() == minPQ.size()){
                maxPQ.add(Integer.parseInt(br.readLine()));
                
                if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()){
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            else{
                minPQ.add(Integer.parseInt(br.readLine()));
                
                if(maxPQ.peek() > minPQ.peek()){
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            sb.append(maxPQ.peek()).append('\n');
        }
        
        System.out.println(sb);
    }
}