import java.io.*;
import java.util.*;

class Main{
    static int node[][];
    static boolean[] check;
    static int cnt;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        
        node = new int[n + 1][n + 1];
        check = new boolean[n + 1];
        
        for(int i = 0; i < e; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	int v1 = Integer.parseInt(st.nextToken());
        	int v2 = Integer.parseInt(st.nextToken());
        	
        	node[v1][v2] = 1;
        	node[v2][v1] = 1;
        }
        
        dfs(1);
        
        System.out.println(cnt - 1);
    }
    
    static void dfs(int start) {
    	if(check[start] == true) {
    		return;
    	}
    	
    	check[start] = true;
    	cnt++;
    	
    	for(int i = 0; i < node[start].length; i++) {
    		if(node[start][i] == 1 && !check[i]) {
    			dfs(i);
    		}
    	}
    }
}