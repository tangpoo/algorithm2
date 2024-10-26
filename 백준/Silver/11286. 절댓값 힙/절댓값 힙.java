import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->{
        	
        	int abs1 = Math.abs(o1);
        	int abs2 = Math.abs(o2);
        	
        	if(abs1 == abs2) return o1 > o2 ? 1 : -1;
        	return abs1 - abs2;
        });
        
        for(int i = 0; i < n; i++) {
        	int val = Integer.parseInt(br.readLine());
        	
        	if(val == 0) {
        		if(pq.isEmpty()) {
        			sb.append(0).append('\n');
        		}
        		else {
        			sb.append(pq.poll()).append('\n');
        		}
        	}
        	else {
        		pq.add(val);
        	}
        }
        
        System.out.println(sb);
    }
}