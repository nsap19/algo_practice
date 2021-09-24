package SSAFY;

import java.io.*;
import java.util.*;

public class Main_백준_7576_토마토_이혜민_660ms {
    static int M, N, box[][], day = 0;
    static Queue<int[]> tomato = new LinkedList<>(); //익은 토마토의 위치를 저장
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) tomato.add(new int[]{i, j, 0});
            }
        }

        getDay();

        //안익은 토마토 있는지 확인
        boolean flag = true;
        loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    flag = false;
                    break loop;
                }
            }
        }

        if (flag) System.out.println(day);
        else System.out.println(-1);

    }

    private static void getDay() {

        while (tomato.size() > 0) {
            int[] t = tomato.poll();
            int r = t[0];
            int c = t[1];
            day = t[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (box[nr][nc] != 0) continue;

                box[nr][nc] = 1;
                tomato.add(new int[]{nr, nc, day + 1});
            }
        }
    }
}
