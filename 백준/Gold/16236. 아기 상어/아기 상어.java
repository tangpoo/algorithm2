import java.io.*;
import java.util.*;

class Main{
    static int[][] board;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        int[] cur = null;


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 9){
                    cur = new int[]{i, j};
                    board[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0;
        int move = 0;

        while(true){
            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visit = new boolean[n][n];

            q.add(new int[]{cur[0], cur[1], 0});
            visit[cur[0]][cur[1]] = true;

            boolean ck = false;

            while(!q.isEmpty()){
                cur = q.poll();

                for(int i = 0; i < 4; i++){
                    int nx = dx[i] + cur[0];
                    int ny = dy[i] + cur[1];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n || visit[nx][ny] || board[nx][ny] > size)
                        continue;

                    q.add(new int[]{nx, ny, cur[2] + 1});
                    visit[nx][ny] = true;
                }
                                if(board[cur[0]][cur[1]] != 0 && board[cur[0]][cur[1]] < size){
                    board[cur[0]][cur[1]] = 0;
                    eat++;
                    move += cur[2];
                    ck = true;
                    break;
                }
            }

            if(!ck)
                break;

            if(size == eat){
                size++;
                eat = 0;
            }
        }
        System.out.println(move);
    }
}