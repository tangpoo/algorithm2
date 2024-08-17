import java.io.*;
import java.util.*;

class Main{
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < m; i++){
        	st = new StringTokenizer(br.readLine());
        	
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(c == 0){
                union(a, b);
            }
            else{
                if(check(a, b)){
                    sb.append("YES" + "\n");
                }
                else{
                    sb.append("NO" + "\n");
                }
            }
        }
        System.out.println(sb);
    }
    
    public static int find(int a){
        if(parent[a] == a) return a;
        
        return parent[a] = find(parent[a]);
    }
    
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a != b){
            parent[b] = a;
        }
    }
    
    public static boolean check(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a == b) return true;
        else return false;
    }
}