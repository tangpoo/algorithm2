import java.util.*;
class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<List<Node>> table_list = new ArrayList<>();
    static List<List<Node>> board_list = new ArrayList<>();
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        int len = game_board.length;
        
        boolean[][] visit_table = new boolean[len][len];
        boolean[][] visit_board = new boolean[len][len];
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(table[i][j] == 1 && !visit_table[i][j]){
                    bfs(i, j, table_list, visit_table, 1, table);
                }
                if(game_board[i][j] == 0 && !visit_board[i][j]){
                    bfs(i, j, board_list, visit_board, 0, game_board);
                }
            }
        }
        
        answer = findBlock(table_list, board_list);
        
        return answer;
    }
    
    static void bfs(int x, int y, List<List<Node>> list, boolean[][] visit, int empty, int[][] board){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        List<Node> subList = new ArrayList<>();
        subList.add(new Node(0, 0));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
                if(!visit[nx][ny] && board[nx][ny] == empty){
                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    subList.add(new Node(nx - x, ny - y));
                }
            }
        }
        list.add(subList);
    }
    
    static int findBlock(List<List<Node>> table, List<List<Node>> board){
        int size = 0;
        boolean[] visit = new boolean[board.size()];
        for(int i = 0; i < table.size(); i++){
            List<Node> subList = table.get(i);
            
            for(int j = 0; j < board.size(); j++){
                if(subList.size() != board.get(j).size() || visit[j]) continue;
                
                if(isRotate(subList, board.get(j))){
                    size += board.get(j).size();
                    visit[j] = true;
                    break;
                }
            }
        }
        return size;
    }
    
    static boolean isRotate(List<Node> table, List<Node> board){
        Collections.sort(board);
        
        for(int i = 0; i < 4; i++){
            Collections.sort(table);
            
            int curX = table.get(0).x;
            int curY = table.get(0).y;
            for(int j = 0; j < table.size(); j++){
                table.get(j).x -= curX;
                table.get(j).y -= curY;
            }
            
            boolean check = true;
            for(int j = 0; j < table.size(); j++){
                if(table.get(j).x != board.get(j).x || table.get(j).y != board.get(j).y){
                    check = false; 
                    break;
                }       
            }
            if(check) return true;
            
            for(int j = 0; j < table.size(); j++){
                int tmp = table.get(j).x;
                table.get(j).x = table.get(j).y;
                table.get(j).y = -tmp;
            }
        }
        return false;
    }
}
class Node implements Comparable<Node>{
    int x, y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int compareTo(Node o){
        int res = Integer.compare(this.x, o.x);
        if(res == 0) res = Integer.compare(this.y, o.y);
        return res;
    }
}