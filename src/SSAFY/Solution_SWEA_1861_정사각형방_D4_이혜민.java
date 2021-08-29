package SSAFY;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_이혜민 {
    static int N, arr[][], totalCnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            //배열 초기화
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            int num = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    totalCnt = 1;
                    checkRoom(i, j, arr[i][j]);
                    if (totalCnt > max) {
                        max = totalCnt;
                        num = arr[i][j];
                    } else if (totalCnt == max) {
                        if (arr[i][j] < num) num = arr[i][j];

                    }
                }
            }
            sb.append("#").append(testCase).append(" ").append(num).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void checkRoom(int r, int c, int n) {
        //카운트 종료 지점 정하기
        //방번호가 끝번호일 때
        if (arr[r][c] == N * N) {
            return;
        }

        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dr[i];
            nc = c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                continue;
            }

            //이동하려는 방이 현재 방보다 1 크다면 다시 탐색
            if (arr[nr][nc] == n + 1) {
                totalCnt++;
                checkRoom(nr, nc, n + 1);
            }


        }


    }
}
