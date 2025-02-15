import java.io.*;
import java.util.*;

class Main {

    static int[][] map;
    static int n;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int depth) {
        if (depth == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }
            return;
        }

        int[][] nextMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            nextMap[i] = map[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            dfs(depth + 1);
            for (int j = 0; j < n; j++) {
                map[j] = nextMap[j].clone();
            }
        }
    }

    static void move(int dir) {
        Queue<Integer> q = new LinkedList<>();
        if (dir == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[j][i] != 0) {
                        q.add(map[j][i]);
                        map[j][i] = 0;
                    }
                }

                int idx = 0;
                while (!q.isEmpty()) {
                    int val = q.poll();

                    if (map[idx][i] == 0) {
                        map[idx][i] = val;
                    } else if (map[idx][i] == val) {
                        map[idx++][i] = val * 2;
                    } else {
                        map[++idx][i] = val;
                    }
                }
            }
        } else if (dir == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (map[i][j] != 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                int idx = n - 1;
                while (!q.isEmpty()) {
                    int val = q.poll();

                    if (map[i][idx] == 0) {
                        map[i][idx] = val;
                    } else if (map[i][idx] == val) {
                        map[i][idx--] = val * 2;
                    } else {
                        map[i][--idx] = val;
                    }
                }
            }
        } else if (dir == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (map[j][i] != 0) {
                        q.add(map[j][i]);
                        map[j][i] = 0;
                    }
                }

                int idx = n - 1;
                while (!q.isEmpty()) {
                    int val = q.poll();

                    if (map[idx][i] == 0) {
                        map[idx][i] = val;
                    } else if (map[idx][i] == val) {
                        map[idx--][i] = val * 2;
                    } else {
                        map[--idx][i] = val;
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0) {
                        q.add(map[i][j]);
                        map[i][j] = 0;
                    }
                }

                int idx = 0;
                while (!q.isEmpty()) {
                    int val = q.poll();

                    if (map[i][idx] == 0) {
                        map[i][idx] = val;
                    } else if (map[i][idx] == val) {
                        map[i][idx++] = val * 2;
                    } else {
                        map[i][++idx] = val;
                    }
                }
            }
        }
    }
}