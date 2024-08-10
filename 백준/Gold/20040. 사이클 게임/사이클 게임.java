import java.io.*;
import java.util.*;

class Main{
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;
        
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(!union(a, b)){
                ans = i + 1;
                break;
            }
        }
        System.out.println(ans);
    }
    
    static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    
    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a == b){
            return false;
        }
        parent[b] = a;
        return true;
    }
}