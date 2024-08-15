import java.io.*;
import java.util.*;

class Main{
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int num = Integer.parseInt(st.nextToken());
                
                if(num == 1){
                    union(i, j);
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        
        for(int i = 1; i < m; i++){
            int now = Integer.parseInt(st.nextToken());
            
            if(start != find(now)){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
    
    static int find(int a){
        if(parent[a] == a) return a;
        
        return parent[a] = find(parent[a]);
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a != b){
            parent[b] = a;
        }
    }
}