import java.io.*;
import java.util.*;

class Main{
    
    static int[] board;
	static int N, M;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());		
		
		board = new int[101];
		
		
		for(int i = 1; i < board.length; i++) {
			board[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x] = y;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x] = y;
		}
		int result = bfs(1);
		System.out.println(result);
	}
	
	static int bfs(int start) {
		int[] check = new int[101];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		check[start] = 0;
		
		while(true) {
			int num = q.poll();
			
			for(int i = 1; i < 7; i++) {
				int newNode = num + i;
				
				if(newNode > 100) {
					continue;
				}
				
				if(check[board[newNode]] == 0) {
					q.offer(board[newNode]);
					check[board[newNode]] = check[num] + 1;
				}
				
				if(board[newNode] == 100) {
					return check[100];
				}
			}
		}
	}
}