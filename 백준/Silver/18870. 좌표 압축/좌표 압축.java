import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

class Main{
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] origin = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
        	sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(sorted);
        
        int rank = 0;
        for(int v : sorted) {
        	if(!rankingMap.containsKey(v)) {
        		rankingMap.put(v,  rank);
        		rank++;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int key : origin) {
        	int ranking = rankingMap.get(key);
        	sb.append(ranking).append(' ');
        }
        
        System.out.println(sb);
	}
}