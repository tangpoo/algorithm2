import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int[][] board;
    static int gray = 0, white = 0, black = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
                
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j < n; j++) {
        		board[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        partition(0, 0, n);
        
        System.out.println(gray);
        System.out.println(white);
        System.out.println(black);
    }
    
    static void partition(int x, int y, int size) {
    	if(checkColor(x, y, size)) {
    		if(board[x][y] == -1) {
    			gray++;
    		}
    		else if(board[x][y] == 0) {
    			white++;
    		}
    		else {
    			black++;    			
    		}
    		return;
    	}
    	
    	int new_size = size / 3;
    	
    	partition(x, y, new_size);
    	partition(x, y + new_size, new_size);
    	partition(x, y + new_size * 2, new_size);
    	partition(x + new_size, y, new_size);
    	partition(x + new_size, y + new_size, new_size);
    	partition(x + new_size, y + new_size * 2, new_size);
    	partition(x + new_size * 2, y, new_size);
    	partition(x + new_size * 2, y + new_size, new_size);
    	partition(x + new_size * 2, y + new_size * 2, new_size);
    	
    }
    
    static boolean checkColor(int x, int y, int size) {
    	int value = board[x][y];
    	
    	for(int i = x; i < x + size; i++) {
    		for(int j = y; j < y + size; j++) {
    			if(value != board[i][j]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
