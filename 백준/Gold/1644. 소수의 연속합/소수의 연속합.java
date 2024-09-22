import java.util.*;
import java.io.*;

class Main{
    
    static ArrayList<Integer> list = new ArrayList<>();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        getPrime(N);
        
        int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		while(start <= end && end < list.size()){
			if(sum < N) {
				sum += list.get(end++);
			} else {
				if(sum == N) {
					cnt++;
				}
				sum -= list.get(start++);
			}
		}
		
		System.out.println(cnt);
	}
    
    static void getPrime(int N){
        boolean[] visit = new boolean[N+1];
        visit[0] = visit[1] = true;
        for(int i = 2; i * i <= N; i++){
            if(!visit[i]){
                for(int j = i * i; j <= N; j += i){
                    visit[j] = true;
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if(!visit[i]) list.add(i);
        }
        list.add(0);
    }
}