package SSAFY;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Air {
    int r, c;

    public Air(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main_백준_2636_치즈_이혜민_136ms {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        int count = 0;
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) count++;
            }
        }

        int time = 0;
        int lastCnt = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (count > 0) {
            time++;
            lastCnt = count;

            boolean[][] visited = new boolean[H][W];
            Queue<Air> queue = new LinkedList<>();
            queue.add(new Air(0, 0));
            visited[0][0] = true;

            while (queue.size() > 0) {
                Air cur = queue.poll();
                int r = cur.r;
                int c = cur.c;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc]) continue;
                    visited[nr][nc] = true;

                    if (map[nr][nc] == 0) queue.add(new Air(nr, nc));
                    else {
                        count--;
                        map[nr][nc] = 0;
                    }

                }
            }
        }

        System.out.println(time);
        System.out.println(lastCnt);


    }
}
