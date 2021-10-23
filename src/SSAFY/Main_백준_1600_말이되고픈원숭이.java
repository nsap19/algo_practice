package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
    int r, c, k, cnt;

    public Location(int r, int c, int k, int cnt) {
        this.r = r;
        this.c = c;
        this.k = k;
        this.cnt = cnt;
    }
}

public class Main_백준_1600_말이되고픈원숭이 {
    static int H, W, K;
    static Queue<Location> q = new LinkedList<>();
    static int[][] map;
    static int[][][] visited;
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine()); //말처럼 움직일 수 있는 횟수
        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new int[K + 1][H][W];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < H; j++) {
                Arrays.fill(visited[i][j], MAX);
            }
        }

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0][0] = 0;
        int endR = H - 1, endC = W - 1;
        q.add(new Location(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Location loc = q.poll();
            int row = loc.r;
            int col = loc.c;
            int k = loc.k;
            int cnt = loc.cnt;

            moveMonkey(row, col, k, cnt);
            if (k < K) moveHorse(row, col, k, cnt);
        }

        int answer = MAX;
        for (int i = 0; i <= K; i++) {
            if (visited[i][endR][endC] < answer)
                answer = visited[i][endR][endC];
        }
        if (answer == MAX) System.out.println(-1);
        else System.out.println(answer);


    }

    private static void moveMonkey(int r, int c, int k, int cnt) {
//        System.out.println(r + " " + c + " " + visited[k][r][c]);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
            if (map[nr][nc] == 1) continue; //갈수없는 곳이면 넘어가기
            if (visited[k][nr][nc] != MAX) continue; //방문했으면 넘어가기
            if (visited[k][nr][nc] > cnt + 1) {
                visited[k][nr][nc] = cnt + 1;
                q.add(new Location(nr, nc, k, cnt + 1));
            }

        }
    }

    private static void moveHorse(int r, int c, int k, int cnt) {
//        System.out.println("horse "+r+" "+c);
        int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
        int nr, nc, nk;

        for (int i = 0; i < 8; i++) {
            nr = r + dr[i];
            nc = c + dc[i];
            nk = k + 1;
            if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
            if (map[nr][nc] == 1) continue; //갈수없는 곳이면 넘어가기
            if (visited[nk][nr][nc] != MAX) continue; //이미 방문했으면 넘어가기
            if (visited[nk][nr][nc] > cnt + 1) {
                visited[nk][nr][nc] = cnt + 1;
                q.add(new Location(nr, nc, nk, cnt + 1));
            }
        }
    }

}
