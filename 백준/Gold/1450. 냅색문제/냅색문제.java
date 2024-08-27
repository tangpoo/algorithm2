import java.util.*;
import java.io.*;

class Main{
    static int C;
	static int[] arr;
	static List<Integer> left, right;
	
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        left = new ArrayList<>();
        right = new ArrayList<>();
        comb(left, 0, N/2, 0);
        comb(right, N/2, N, 0);
        right.sort((a,b) -> (a-b));
        
        int cnt = 0;
        int idx = 0;
        for(int i = 0; i < left.size(); i++) {
        	idx = upperBound(0, right.size()-1, left.get(i));
        	cnt += idx + 1;
        }
        System.out.println(cnt);
    }
    
    static int upperBound(int s, int e, int val) {
    	while(s <= e) {
    		int mid = (s + e) / 2;
    		
    		if(right.get(mid) <= C - val) {
    			s = mid + 1;
    		}
    		else {
    			e = mid - 1;
    		}
    	}
    	return e;
    }
    
    static void comb(List<Integer> list, int start, int end, int sum) {
    	if(sum > C) return;
    	if(start == end) {
    		list.add(sum);
    		return;
    	}
    	comb(list, start + 1, end, sum);
    	comb(list, start + 1, end, sum + arr[start]);
    }
}
