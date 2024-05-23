import java.io.*;
import java.util.*;

class Main {

    static int R;
    static int C;

    static char[][] cave;
    static int[][] cluster;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cave = new char[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                cave[i][j] = str.charAt(j);
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int H = Integer.parseInt(st.nextToken());

            throwStick(H, i%2==0?true:false);
            setCluster();
        }

        for(int i = 0; i < R; i++){
            System.out.println(cave[i]);
        }
    }

    private static void throwStick(int h, boolean direction) {
        if(direction){
            for(int i = 0; i < C; i++){
                if(cave[R - h][i] == 'x'){
                    cave[R - h][i] = '.';
                    break;
                }
            }
        } else {
            for(int i = C - 1; i >= 0; i--){
                if(cave[R - h][i] == 'x'){
                    cave[R - h][i] = '.';
                    break;
                }
            }
        }
    }

    private static void setCluster(){
        cluster = new int[R][C];

        int clusterNum = 1;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(cluster[i][j] == 0 && cave[i][j] == 'x'){
                    if(findCluster(i, j, clusterNum)){
                        return;
                    }
                    clusterNum++;
                }
            }
        }
    }

    private static boolean findCluster(int r, int c, int clusterNum) {
        cluster[r][c] = clusterNum;

        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> arr = new ArrayList<>();
        q.add(new Node(r, c));

        int max = -1;
        while(!q.isEmpty()){
            Node cur = q.poll();
            max = Math.max(max, cur.x);

            for(int i = 0; i < 4; i++){
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];

                if(x < 0 || y < 0 || x >= R || y >= C){
                    continue;
                }

                if(cluster[x][y] == 0 && cave[x][y] == 'x'){
                    cluster[x][y] = clusterNum;
                    q.add(new Node(x, y));
                }
            }
            arr.add(cur);
        }

        if(max != R-1){
            moveCluster(arr);
            return true;
        }

        return false;
    }

    private static void moveCluster(ArrayList<Node> arr) {
        int move = 1;

        for(Node node : arr){
            cave[node.x][node.y] = '.';
        }

        outerLoop:
        while(true){
            for(Node node : arr){
                if(node.x + move == R || cave[node.x + move][node.y] == 'x'){
                    move--;
                    break outerLoop;
                }
            }
            move++;
        }

        for(Node node : arr){
            cave[node.x + move][node.y] = 'x';
        }
    }
}

class Node{
    int x, y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}