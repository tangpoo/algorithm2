import java.io.*;
import java.util.*;

class Main{
    
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int[][] arr;
    static boolean[][] check;
    static int count = 0, block = 0;
    static int nowX, nowY, N;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            
            for(int j = 0; j < N; j++){
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(check[i][j] == false && arr[i][j] == 1){
                    count = 0;
                    block++;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        sb.append(block).append('\n');
        for(int num : list){
            sb.append(num).append('\n');
        }
        System.out.println(sb);
    }
    
    static void dfs(int x, int y){
        check[x][y] = true;
        arr[x][y] = block;
        count++;
        
        for(int i = 0; i < 4; i++){
            nowX = dirX[i] + x;
            nowY = dirY[i] + y;
            
            if(Range_check() && arr[nowX][nowY] == 1 && check[nowX][nowY] == false){
                check[nowX][nowY] = true;
                arr[nowX][nowY] = block;
                dfs(nowX, nowY);
            }
        }
    }
    
    
    static boolean Range_check(){
        
        return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
    }
}