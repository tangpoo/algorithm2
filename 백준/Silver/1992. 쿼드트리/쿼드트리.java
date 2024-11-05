import java.io.*;
import java.util.*;

class Main{
    
    static int[][] img;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        img = new int[n][n];
        
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            
            for(int j = 0; j < n; j++){
                img[i][j] = str.charAt(j) - '0';
            }
        }
        
        QuadTree(0, 0, n);
        System.out.println(sb);
        
    }
    static void QuadTree(int x, int y, int size){
        
        if(isPossible(x, y, size)){
            sb.append(img[x][y]);
            return;
        }
        
        int new_size = size / 2;
        sb.append('(');
        
        QuadTree(x, y, new_size);
        QuadTree(x, y + new_size, new_size);
        QuadTree(x + new_size, y, new_size);        
        QuadTree(x + new_size, y + new_size, new_size);
        
        sb.append(')');
    }
    
    static boolean isPossible(int x, int y, int size){
        int value = img[x][y];
        
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(img[i][j] != value){
                    return false;
                }
            }
        }
        return true;
    }
}