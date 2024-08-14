import java.io.*;
import java.util.*;

class Main{
    
    static int[] parent, level;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T --> 0){
            int n = Integer.parseInt(br.readLine());
            parent = new int[n * 2];
            level = new int[n * 2];
            
            for(int i = 0; i < n * 2; i++){
                parent[i] = i;
                level[i] = 1;
            }
            
            int idx = 0;
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                
                String a = st.nextToken();
                String b = st.nextToken();
                
                if(!map.containsKey(a)){
                    map.put(a, idx++);
                }
                if(!map.containsKey(b)){
                    map.put(b, idx++);
                }
                
                sb.append(union(map.get(a) , map.get(b)) + "\n");
            }
        }
        System.out.println(sb);
    }
    
    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    static int union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a != b){
            parent[b] = a;
            level[a] += level[b];
            
            level[b] = 1;
        }
        return level[a];
    }
}