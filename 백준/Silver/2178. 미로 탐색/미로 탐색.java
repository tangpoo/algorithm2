import java.io.*;
import java.util.*;

class Main{
    
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] check;
    static Queue<Node> q = new LinkedList<>();
    
    static int nowX, nowY;
    static int x, y;
    static int N, M;
    
    static class Node{
    	int x;
    	int y;
    	
    	public Node(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        check = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            
            for(int j = 0; j < str.length(); j++){
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        
        bfs(0, 0);
        
        System.out.println(map[N-1][M-1]);
    }
    
    static void bfs(int x, int y){        
        q.offer(new Node(x, y));
        check[y][x] = true;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            
            for(int i = 0; i < 4; i++) {
            	nowY = node.y + dirY[i];
            	nowX = node.x + dirX[i];
            	
            	if(Range_check() && check[nowY][nowX] == false && map[nowY][nowX] == 1) {
            		q.offer(new Node(nowX, nowY));
            		check[nowY][nowX] = true;
            		
            		map[nowY][nowX] = map[node.y][node.x] + 1;
            		
            		if(check[N-1][M-1] == true) {
            			return;
            		}
            	}
            }
        }
    }
    static boolean Range_check() {
    	return (nowX >= 0 && nowX < M && nowY >= 0 && nowY < N);
    }
}