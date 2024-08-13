import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        ArrayList<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<Integer>());
        }       
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list.get(a).add(b);
            arr[b]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(arr[i] == 0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            
            for(int i : list.get(node)){
                arr[i]--;
                if(arr[i] == 0){
                    q.add(i);
                }
            }
        }
    }
}
