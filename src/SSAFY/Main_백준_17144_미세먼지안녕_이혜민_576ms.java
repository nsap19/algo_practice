package SSAFY;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17144_미세먼지안녕_이혜민_576ms {
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        int[][] ac = new int[2][2]; //공기청정기 위치
        int acIdx = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    ac[acIdx][0] = i;
                    ac[acIdx++][1] = j;
                }
            }
        }


        for (int time = 0; time < T; time++) {
            //미세먼지 퍼지기
            int[][] temp = new int[R][C];
            for (int i = 0; i < R; i++) System.arraycopy(map[i], 0, temp[i], 0, C);

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {
                        int cnt = 0;
                        for (int dir = 0; dir < 4; dir++) {
                            int nr = i + dr[dir];
                            int nc = j + dc[dir];

                            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                            if (map[nr][nc] == -1) continue;
                            cnt++;
                            temp[nr][nc] += map[i][j] / 5;
                        }
                        temp[i][j] -= (map[i][j] / 5) * cnt;
                    }
                }
            }

            for (int i = 0; i < R; i++) System.arraycopy(temp[i], 0, map[i], 0, C);

//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            //공기청정기 돌아가기
            //위쪽 공기청정기
            int r = ac[0][0], c = ac[0][1];
            //왼쪽 세로 방향
            for (int i = r - 1; i > 0; i--) {
                map[i][c] = map[i - 1][c];
            }
            //위쪽 가로방향
            for (int i = c; i < C - 1; i++) {
                map[0][i] = map[0][i + 1];
            }
            //오른쪽 세로방향
            for (int i = 0; i < r; i++) {
                map[i][C - 1] = map[i + 1][C - 1];
            }
            //아래쪽 가로방향
            for (int i = C - 1; i > c + 1; i--) {
                map[r][i] = map[r][i - 1];
            }
            map[r][c + 1] = 0;


            //아래쪽 공기청정기
            r = ac[1][0];
            c = ac[1][1];
            //왼쪽 세로방향
            for (int i = r + 1; i < R - 1; i++) {
                map[i][c] = map[i + 1][c];
            }
            //아래쪽 가로방향
            for (int i = c; i < C - 1; i++) {
                map[R - 1][i] = map[R - 1][i + 1];
            }
            //오른쪽 세로방향
            for (int i = R - 1; i > r; i--) {
                map[i][C - 1] = map[i - 1][C - 1];
            }
            //위쪽 가로방향
            for (int i = C - 1; i > c + 1; i--) {
                map[r][i] = map[r][i - 1];
            }
            map[r][c + 1] = 0;
        }

        int total = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) total += map[i][j];
//                System.out.print(map[i][j] + " ");
            }
//            System.out.println();
        }

        System.out.println(total);
    }
}
