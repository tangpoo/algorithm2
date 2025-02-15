import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int[][] board;
    static Queue<DirectionInfo> q = new LinkedList<>();
    static int result = 0;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());

            int second = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            q.add(new DirectionInfo(second, dir));
        }

        move();

        System.out.println(result);
    }

    static void move() {
        int x = 0, y = 0, d = 0;
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{x, y});

        while (true) {
            result++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                break;
            }

            for (int[] body : snake) {
                if (body[0] == nx && body[1] == ny) {
                    return;
                }
            }

            if (board[nx][ny] == 1) {
                board[nx][ny] = 0;
            } else {
                snake.pollFirst();
            }

            snake.add(new int[]{nx, ny});
            x = nx;
            y = ny;

            if (!q.isEmpty() && q.peek().second == result) {
                DirectionInfo directionInfo = q.poll();

                if (directionInfo.direction == 'D') {
                    d = (d + 1) % 4;
                } else {
                    d = (d + 3) % 4;
                }
            }
        }
    }
}

class DirectionInfo {

    int second;
    char direction;

    public DirectionInfo(int second, char direction) {
        this.second = second;
        this.direction = direction;
    }
}