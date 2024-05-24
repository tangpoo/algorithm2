import java.io.*;
import java.util.*;

class Main {

    static class position implements Comparable<position> {
        int x, y, count;

        public position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(position o) {
            return this.count - o.count;
        }
    }

    static char[][] map;
    static ArrayList<position> prisoner;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] prisonOne, prisonTwo, prisonThree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map = new char[h + 2][w + 2];
            prisoner = new ArrayList<>();
            prisoner.add(new position(0, 0, 0));

            for (int i = 0; i < h; i++) {
                String str = br.readLine();

                for (int j = 0; j < str.length(); j++) {
                    map[i + 1][j + 1] = str.charAt(j);

                    if (map[i + 1][j + 1] == '$') {
                        prisoner.add(new position(j + 1, i + 1, 0));
                    }
                }
            }

            prisonOne = escape(prisoner.get(0), h, w);
            prisonTwo = escape(prisoner.get(1), h, w);
            prisonThree = escape(prisoner.get(2), h, w);

            sb.append(minDoor(h, w)).append('\n');
        }

        System.out.println(sb);
    }

    static int[][] escape(position p, int h, int w) {
        PriorityQueue<position> pq = new PriorityQueue<>();
        visited = new boolean[h + 2][w + 2];
        int[][] result = new int[h + 2][w + 2];
        visited[p.y][p.x] = true;
        pq.add(p);
        while (!pq.isEmpty()) {
            position cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
            result[y][x] = count;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < w + 2 && ny < h + 2 && !visited[ny][nx]) {
                    if (map[ny][nx] != '*') {
                        if (map[ny][nx] == '#') {
                            pq.add(new position(nx, ny, count + 1));
                        } else {
                            pq.add(new position(nx, ny, count));
                        }
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return result;
    }

    static int minDoor(int h, int w) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < h + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (map[i][j] == '*') {
                    continue;
                }

                int sum = prisonOne[i][j] + prisonTwo[i][j] + prisonThree[i][j];
                if (map[i][j] == '#') {
                    sum -= 2;
                }

                if (result > sum && visited[i][j]) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
