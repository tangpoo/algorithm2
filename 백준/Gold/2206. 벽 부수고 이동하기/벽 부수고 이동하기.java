import java.io.*;
import java.util.*;

class Main{
    static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] board;
	static boolean[][][] visited;
	static int n, m;
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());		
		
		board = new int[n][m];
		visited = new boolean[n][m][2];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < m; j++) {
				board[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		System.out.println(bfs(0, 0));
	}
	private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1, 0));
        visited[x][y][0] = true; //0은 벽을 부시지 않고 방문한 노드의 방문 여부
        visited[x][y][1] = true; //1은 벽을 부시면서 방문한 노드의 방문 여부
 
        while (!q.isEmpty()) {
            Node current = q.poll();
 
            if (current.x == n - 1 && current.y == m - 1) return current.count;
 
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
 
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(board[nx][ny] == 0) { //벽이 아닐 때
                        if (visited[nx][ny][current.wall] == false) { //현재까지 온 방법(벽을 부쉈는지 아닌지)으로 방문한 적이 없다면 방문한다.
                            q.add(new Node(nx, ny, current.count + 1, current.wall));
                            visited[nx][ny][current.wall] = true;
                        }
                    }    
                    else if (board[nx][ny] == 1) { //벽일때
                        if (current.wall == 0 && visited[nx][ny][1] == false) { //현재까지 벽을 부순적이 없고, 벽을 부숴서 방문한 적이 없다면 방문한다.
                            q.add(new Node(nx, ny, current.count + 1, 1));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
 
        return -1;
    }
 
	
	public static class Node{
		private int x;
		private int y;
		private int count;
		private int wall;
		
		public Node(int x, int y, int count, int wall) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.wall = wall;
		}
	}
}
