import java.io.*;
import java.util.*;

class Main{
    
    static class Node{
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static Queue<Node> q;
	static Queue<Node> waterq;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static char[][] map;
	static boolean[][] visited;
	static Node[] swan;
	static int R, C;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		waterq = new LinkedList<>();
		q = new LinkedList<>();
		swan = new Node[2];
		map = new char[R][C];
		visited = new boolean[R][C];
		
		int swanIdx = 0;
		for(int r = 0; r < R; ++r) {
			char[] line = br.readLine().toCharArray();
			
			for(int c = 0; c < C; ++c) {
				map[r][c] = line[c];
				
				if(map[r][c] == 'L') {
					swan[swanIdx++] = new Node(r, c);
				}
				if(map[r][c] != 'X') {
					waterq.offer(new Node(r, c));
				}
			}
		}
		
		q.offer(swan[0]);
		visited[swan[0].r][swan[0].c] = true;
		
		int day = 0;
		boolean meet = false;
		
		while(true) {
			Queue<Node> nextQ = new LinkedList<>();
			
			while(!q.isEmpty()) {
				Node now = q.poll();
				
				if(now.r == swan[1].r && now.c == swan[1].c) {
					meet = true;
					break;
				}
				
				for(int d = 0; d < 4; ++d) {
					int nr = now.r + dir[d][0];
					int nc = now.c + dir[d][1];
					
					if(nr >= R || nr < 0 || nc >= C || nc < 0|| visited[nr][nc]) {
						continue;
					}
					visited[nr][nc] = true;
					
					if(map[nr][nc] == 'X') {
						nextQ.offer(new Node(nr, nc));
						continue;
					}
					
					q.offer(new Node(nr, nc));
				}				
			}
			if(meet) break;
			
			q = nextQ;
			
			int size = waterq.size();
			
			for(int i = 0; i < size; ++i) {
				Node now = waterq.poll();
				
				for(int d = 0; d < 4; ++d) {
					int nr = now.r + dir[d][0];
					int nc = now.c + dir[d][1];
					
					if(nr >= R || nr < 0 || nc >= C || nc < 0)
						continue;
					
					if(map[nr][nc] == 'X') {
						map[nr][nc] = '.';
						waterq.offer(new Node(nr, nc));
					}
				}
			}
			day++;
		}
		System.out.println(day);
	}
}
