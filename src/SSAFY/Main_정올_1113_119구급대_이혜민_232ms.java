package SSAFY;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Move implements Comparable<Move> {
    int r, c, dir, cnt;

    public Move(int r, int c, int dir, int cnt) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Move o) {
        return this.cnt - o.cnt;
    }
}

public class Main_정올_1113_119구급대_이혜민_232ms {
    static int M, N, m, n, map[][];
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1}; //상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        PriorityQueue<Move> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[M][N];
        pq.add(new Move(0, 0, -1, -1));
        visited[0][0] = true;

        while (pq.size() > 0) {
            Move cur = pq.poll();
            int r = cur.r, c = cur.c, dir = cur.dir, cnt = cur.cnt;

            if (r == m && c == n) return cnt;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                if (dir == i) pq.add(new Move(nr, nc, dir, cnt));
                else pq.add(new Move(nr, nc, i, cnt + 1));
            }

        }

        return 0;
    }
}
