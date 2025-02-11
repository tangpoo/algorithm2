import java.io.*;
import java.util.*;

class Main{
    static int[] arr;
	static int n;
	static int count = 0;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		queen(0);
		
		System.out.println(count);
	}
	
	static void queen(int depth) {
		
		if(depth == n) {
			count++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr[depth] = i;
			
			if(Possibility(depth)) {
				queen(depth + 1);
			}
		}
	}
	
	static boolean Possibility(int col) {
		
		for(int i = 0; i < col; i++) {
			if(arr[col] == arr[i]) {
				return false;
			}
			
			else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
