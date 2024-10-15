import java.io.*;
import java.util.*;

class Main{
    
    static int[][] dir = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1},{-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static Point start, end;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while(T --> 0){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            
            st = new StringTokenizer(br.readLine());
            
            start = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            
            end = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), 0);
            
            bfs(start);
        }
        
    }
    
    static void bfs(Point p){
        Queue<Point> q = new LinkedList<>();
        q.add(p);
        visited[p.x][p.y] = true;
        
        while(!q.isEmpty()) {
        	Point temp = q.poll();
        	int tempX = temp.x;
        	int tempY = temp.y;
        	int cnt = temp.cnt;
        	
        	if(tempX == end.x && tempY == end.y) {
        		System.out.println(temp.cnt);
        		return;
        	}
        	
        	for(int i = 0; i < 8; i++) {
        		int nx = tempX + dir[i][0];
        		int ny = tempY + dir[i][1];
        		
        		if(nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == false) {
        			q.add(new Point(nx, ny, cnt + 1));
        			visited[nx][ny] = true;
        		}
        	}
        }
    }
    static class Point{
    	int x, y, cnt;
    	
    	public Point(int x, int y, int cnt) {
    		this.x = x;
    		this.y = y;
    		this.cnt = cnt;
    	}
    }
}