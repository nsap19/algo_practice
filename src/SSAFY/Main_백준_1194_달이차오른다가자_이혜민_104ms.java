package SSAFY;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1194_달이차오른다가자_이혜민_104ms {
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static Queue<int[]> queue;
    static boolean[][][] visited;
    static int n, m;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); //세로 크기
        m = Integer.parseInt(st.nextToken()); //가로크기
        map = new char[n][m];
        visited = new boolean[64][n][m];
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str = new StringTokenizer(br.readLine()).nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0') {
                    queue.add(new int[]{i, j, 0, 0});
                    visited[0][i][j] = true;
                }
            }
        }

        int result = bfs();

        System.out.println(result);
    }

    private static int bfs() {
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            int count = cur[3];

            if (map[r][c] == '1') return count;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                int key = cur[2];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == '#') continue;

                char val = map[nr][nc];
                if (val >= 'a' && val <= 'f') {
                    key = key | (1 << (val - 'a'));
                } else if (val >= 'A' && val <= 'F') {
                    int isExist = (key & (1 << (val - 'A')));
                    if (isExist == 0) continue;
                }

                if (visited[key][nr][nc]) continue;
                visited[key][nr][nc] = true;
                queue.add(new int[]{nr, nc, key, count + 1});
            }
        }

        return -1;
    }

}
