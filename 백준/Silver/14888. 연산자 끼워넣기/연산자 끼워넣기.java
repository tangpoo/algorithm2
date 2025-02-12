import java.io.*;
import java.util.*;

class Main{
    
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] number;
    static int[] operator;
    static int n;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        number = new int[n];
        for(int i = 0; i < n; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        operator = new int[4];
        for(int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(number[0], 1);
        
        System.out.println(MAX);
        System.out.println(MIN);
    }
    
    static void dfs(int num, int idx){
        
        if(idx == n){
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }
        
        for(int i = 0; i < 4; i++){
            if(operator[i] > 0){
                
                operator[i]--;
                
                switch (i) {
                    case 0 : dfs(num + number[idx], idx + 1); break;
			        case 1 : dfs(num - number[idx], idx + 1); break; 
			        case 2 : dfs(num * number[idx], idx + 1); break;
			        case 3 : dfs(num / number[idx], idx + 1); break;
                }
                
                operator[i]++;
            }
        }
    }
}